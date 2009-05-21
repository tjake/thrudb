/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.thrudb.thrudex;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class Document implements TBase, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Document");
  private static final TField INDEX_FIELD_DESC = new TField("index", TType.STRING, (short)1);
  private static final TField KEY_FIELD_DESC = new TField("key", TType.STRING, (short)2);
  private static final TField FIELDS_FIELD_DESC = new TField("fields", TType.LIST, (short)3);
  private static final TField PAYLOAD_FIELD_DESC = new TField("payload", TType.STRING, (short)4);
  private static final TField WEIGHT_FIELD_DESC = new TField("weight", TType.I32, (short)5);

  public String index;
  public static final int INDEX = 1;
  public String key;
  public static final int KEY = 2;
  public List<Field> fields;
  public static final int FIELDS = 3;
  public String payload;
  public static final int PAYLOAD = 4;
  public int weight;
  public static final int WEIGHT = 5;

  private final Isset __isset = new Isset();
  private static final class Isset implements java.io.Serializable {
    public boolean weight = false;
  }

  public static final Map<Integer, FieldMetaData> metaDataMap = Collections.unmodifiableMap(new HashMap<Integer, FieldMetaData>() {{
    put(INDEX, new FieldMetaData("index", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(KEY, new FieldMetaData("key", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(FIELDS, new FieldMetaData("fields", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, Field.class))));
    put(PAYLOAD, new FieldMetaData("payload", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    put(WEIGHT, new FieldMetaData("weight", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.I32)));
  }});

  static {
    FieldMetaData.addStructMetaDataMap(Document.class, metaDataMap);
  }

  public Document() {
    this.weight = 1;

  }

  public Document(
    String index,
    String key,
    List<Field> fields,
    String payload,
    int weight)
  {
    this();
    this.index = index;
    this.key = key;
    this.fields = fields;
    this.payload = payload;
    this.weight = weight;
    this.__isset.weight = true;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Document(Document other) {
    if (other.isSetIndex()) {
      this.index = other.index;
    }
    if (other.isSetKey()) {
      this.key = other.key;
    }
    if (other.isSetFields()) {
      List<Field> __this__fields = new ArrayList<Field>();
      for (Field other_element : other.fields) {
        __this__fields.add(new Field(other_element));
      }
      this.fields = __this__fields;
    }
    if (other.isSetPayload()) {
      this.payload = other.payload;
    }
    __isset.weight = other.__isset.weight;
    this.weight = other.weight;
  }

  @Override
  public Document clone() {
    return new Document(this);
  }

  public String getIndex() {
    return this.index;
  }

  public void setIndex(String index) {
    this.index = index;
  }

  public void unsetIndex() {
    this.index = null;
  }

  // Returns true if field index is set (has been asigned a value) and false otherwise
  public boolean isSetIndex() {
    return this.index != null;
  }

  public void setIndexIsSet(boolean value) {
    if (!value) {
      this.index = null;
    }
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public void unsetKey() {
    this.key = null;
  }

  // Returns true if field key is set (has been asigned a value) and false otherwise
  public boolean isSetKey() {
    return this.key != null;
  }

  public void setKeyIsSet(boolean value) {
    if (!value) {
      this.key = null;
    }
  }

  public int getFieldsSize() {
    return (this.fields == null) ? 0 : this.fields.size();
  }

  public java.util.Iterator<Field> getFieldsIterator() {
    return (this.fields == null) ? null : this.fields.iterator();
  }

  public void addToFields(Field elem) {
    if (this.fields == null) {
      this.fields = new ArrayList<Field>();
    }
    this.fields.add(elem);
  }

  public List<Field> getFields() {
    return this.fields;
  }

  public void setFields(List<Field> fields) {
    this.fields = fields;
  }

  public void unsetFields() {
    this.fields = null;
  }

  // Returns true if field fields is set (has been asigned a value) and false otherwise
  public boolean isSetFields() {
    return this.fields != null;
  }

  public void setFieldsIsSet(boolean value) {
    if (!value) {
      this.fields = null;
    }
  }

  public String getPayload() {
    return this.payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public void unsetPayload() {
    this.payload = null;
  }

  // Returns true if field payload is set (has been asigned a value) and false otherwise
  public boolean isSetPayload() {
    return this.payload != null;
  }

  public void setPayloadIsSet(boolean value) {
    if (!value) {
      this.payload = null;
    }
  }

  public int getWeight() {
    return this.weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
    this.__isset.weight = true;
  }

  public void unsetWeight() {
    this.__isset.weight = false;
  }

  // Returns true if field weight is set (has been asigned a value) and false otherwise
  public boolean isSetWeight() {
    return this.__isset.weight;
  }

  public void setWeightIsSet(boolean value) {
    this.__isset.weight = value;
  }

  public void setFieldValue(int fieldID, Object value) {
    switch (fieldID) {
    case INDEX:
      if (value == null) {
        unsetIndex();
      } else {
        setIndex((String)value);
      }
      break;

    case KEY:
      if (value == null) {
        unsetKey();
      } else {
        setKey((String)value);
      }
      break;

    case FIELDS:
      if (value == null) {
        unsetFields();
      } else {
        setFields((List<Field>)value);
      }
      break;

    case PAYLOAD:
      if (value == null) {
        unsetPayload();
      } else {
        setPayload((String)value);
      }
      break;

    case WEIGHT:
      if (value == null) {
        unsetWeight();
      } else {
        setWeight((Integer)value);
      }
      break;

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  public Object getFieldValue(int fieldID) {
    switch (fieldID) {
    case INDEX:
      return getIndex();

    case KEY:
      return getKey();

    case FIELDS:
      return getFields();

    case PAYLOAD:
      return getPayload();

    case WEIGHT:
      return new Integer(getWeight());

    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  // Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise
  public boolean isSet(int fieldID) {
    switch (fieldID) {
    case INDEX:
      return isSetIndex();
    case KEY:
      return isSetKey();
    case FIELDS:
      return isSetFields();
    case PAYLOAD:
      return isSetPayload();
    case WEIGHT:
      return isSetWeight();
    default:
      throw new IllegalArgumentException("Field " + fieldID + " doesn't exist!");
    }
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Document)
      return this.equals((Document)that);
    return false;
  }

  public boolean equals(Document that) {
    if (that == null)
      return false;

    boolean this_present_index = true && this.isSetIndex();
    boolean that_present_index = true && that.isSetIndex();
    if (this_present_index || that_present_index) {
      if (!(this_present_index && that_present_index))
        return false;
      if (!this.index.equals(that.index))
        return false;
    }

    boolean this_present_key = true && this.isSetKey();
    boolean that_present_key = true && that.isSetKey();
    if (this_present_key || that_present_key) {
      if (!(this_present_key && that_present_key))
        return false;
      if (!this.key.equals(that.key))
        return false;
    }

    boolean this_present_fields = true && this.isSetFields();
    boolean that_present_fields = true && that.isSetFields();
    if (this_present_fields || that_present_fields) {
      if (!(this_present_fields && that_present_fields))
        return false;
      if (!this.fields.equals(that.fields))
        return false;
    }

    boolean this_present_payload = true && this.isSetPayload();
    boolean that_present_payload = true && that.isSetPayload();
    if (this_present_payload || that_present_payload) {
      if (!(this_present_payload && that_present_payload))
        return false;
      if (!this.payload.equals(that.payload))
        return false;
    }

    boolean this_present_weight = true;
    boolean that_present_weight = true;
    if (this_present_weight || that_present_weight) {
      if (!(this_present_weight && that_present_weight))
        return false;
      if (this.weight != that.weight)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id)
      {
        case INDEX:
          if (field.type == TType.STRING) {
            this.index = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case KEY:
          if (field.type == TType.STRING) {
            this.key = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case FIELDS:
          if (field.type == TType.LIST) {
            {
              TList _list0 = iprot.readListBegin();
              this.fields = new ArrayList<Field>(_list0.size);
              for (int _i1 = 0; _i1 < _list0.size; ++_i1)
              {
                Field _elem2;
                _elem2 = new Field();
                _elem2.read(iprot);
                this.fields.add(_elem2);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case PAYLOAD:
          if (field.type == TType.STRING) {
            this.payload = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case WEIGHT:
          if (field.type == TType.I32) {
            this.weight = iprot.readI32();
            this.__isset.weight = true;
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
          break;
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();


    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.index != null) {
      oprot.writeFieldBegin(INDEX_FIELD_DESC);
      oprot.writeString(this.index);
      oprot.writeFieldEnd();
    }
    if (this.key != null) {
      oprot.writeFieldBegin(KEY_FIELD_DESC);
      oprot.writeString(this.key);
      oprot.writeFieldEnd();
    }
    if (this.fields != null) {
      oprot.writeFieldBegin(FIELDS_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.fields.size()));
        for (Field _iter3 : this.fields)        {
          _iter3.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.payload != null) {
      oprot.writeFieldBegin(PAYLOAD_FIELD_DESC);
      oprot.writeString(this.payload);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldBegin(WEIGHT_FIELD_DESC);
    oprot.writeI32(this.weight);
    oprot.writeFieldEnd();
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Document(");
    boolean first = true;

    sb.append("index:");
    if (this.index == null) {
      sb.append("null");
    } else {
      sb.append(this.index);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("key:");
    if (this.key == null) {
      sb.append("null");
    } else {
      sb.append(this.key);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("fields:");
    if (this.fields == null) {
      sb.append("null");
    } else {
      sb.append(this.fields);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("payload:");
    if (this.payload == null) {
      sb.append("null");
    } else {
      sb.append(this.payload);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("weight:");
    sb.append(this.weight);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    // check that fields of type enum have valid values
  }

}

