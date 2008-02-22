/**
 * Copyright (c) 2007- T Jake Luciani
 * Distributed under the New BSD Software License
 *
 * See accompanying file LICENSE or visit the Thrudb site at:
 * http://thrudb.googlecode.com
 *
 **/

#ifdef HAVE_CONFIG_H
#include "thrudex_config.h"
#endif
/* hack to work around thrift and log4cxx installing config.h's */
#undef HAVE_CONFIG_H

#include <concurrency/ThreadManager.h>
#include <concurrency/PosixThreadFactory.h>
#include <protocol/TBinaryProtocol.h>
#include <server/TSimpleServer.h>
#include <server/TThreadPoolServer.h>
#include <server/TNonblockingServer.h>
#include <transport/TServerSocket.h>
#include <transport/TTransportUtils.h>


#include <iostream>
#include <stdexcept>
#include <sstream>
#include <stdio.h>
#include <stdlib.h>

#include "log4cxx/logger.h"
#include "log4cxx/basicconfigurator.h"
#include "log4cxx/propertyconfigurator.h"
#include "log4cxx/helpers/exception.h"

#include "ThrudexHandler.h"
#include "ThrudexBackend.h"
#include "CLuceneBackend.h"
#include "StatsBackend.h"
#include "ConfigFile.h"
#include "utils.h"

using namespace log4cxx;
using namespace log4cxx::helpers;

using namespace std;
using namespace facebook::thrift;
using namespace facebook::thrift::concurrency;
using namespace facebook::thrift::protocol;
using namespace facebook::thrift::transport;
using namespace facebook::thrift::server;
using namespace thrudex;
using namespace boost;

LoggerPtr logger(Logger::getLogger("Thrudex"));

//print usage and die
inline void usage()
{
    cerr<<"thrudex -f /path/to/config.inf"<<endl;
    cerr<<"\tor create ~/.thrudex"<<endl;
    exit(-1);
}

int main(int argc, char **argv) {

    string conf_file   = string(getenv("HOME"))+"/.thrudex";
    bool   nonblocking = true;

    //Parse args
    for(int i=0; i<argc; i++){
        if(string(argv[i]) == "-f" && (i+1) < argc)
            conf_file = argv[i+1];
    }

    if( !file_exists( conf_file ) ){
        usage();
    }

    try{
        //Read da config
        ConfigManager->readFile( conf_file );

        string index_root   = ConfigManager->read<string>("INDEX_ROOT");

        int    thread_count = ConfigManager->read<int>("THREAD_COUNT",3);
        int    server_port  = ConfigManager->read<int>("SERVER_PORT",9099);

        PropertyConfigurator::configure(conf_file);
        setlocale(LC_CTYPE, "en_US.utf8");  //unicode support

        LOG4CXX_INFO(logger, "Starting up");

        string which      = ConfigManager->read<string>("BACKEND","CLucene");
        shared_ptr<ThrudexBackend>    backend(new CLuceneBackend(index_root));


        if (ConfigManager->read<int>("KEEP_STATS", 0))
          backend = shared_ptr<ThrudexBackend> (new StatsBackend (backend));

        shared_ptr<TProtocolFactory>  protocolFactory  (new TBinaryProtocolFactory());

        shared_ptr<ThrudexHandler>    handler          (new ThrudexHandler(backend));
        shared_ptr<TProcessor>        processor        (new ThrudexProcessor(handler));


        shared_ptr<ThreadManager> threadManager =
            ThreadManager::newSimpleThreadManager(thread_count);

        shared_ptr<PosixThreadFactory> threadFactory =
            shared_ptr<PosixThreadFactory>(new PosixThreadFactory());

        threadManager->threadFactory(threadFactory);
        threadManager->start();


        if(nonblocking){

            TNonblockingServer server(processor,
                                      protocolFactory,
                                      server_port,threadManager);

            cerr<<"Starting the server...\n";
            server.serve();
            cerr<<"Server stopped."<<endl;

        } else {

            shared_ptr<TServerTransport>  serverTransport (new TServerSocket(server_port));
            shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());

            TThreadPoolServer server(processor,
                                     serverTransport,
                                     transportFactory,
                                     protocolFactory,
                                     threadManager);

            cerr<<"Starting the server...\n";
            server.serve();
            cerr<<"Server stopped."<<endl;
        }

    }catch(CLuceneError e){
        cerr<<"Caught Fatal CLucene Exception: "<<e.what()<<endl;
    }catch(std::exception e){
        cerr<<"Caught Fatal Exception: "<<e.what()<<endl;
    }catch(ConfigFile::file_not_found e){
        cerr<<"ConfigFile Fatal Exception: "<<e.filename<<endl;
    }catch(ConfigFile::key_not_found e){
        cerr<<"ConfigFile Missing Required Key: "<<e.key<<endl;
    }catch(...){
        cerr<<"Caught unknown exception"<<endl;
    }


    return 0;
}
