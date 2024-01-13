package com.assistai.backend.core;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.IOException;
import org.json.JSONException;

/**
 *
 * @author Ecenaz Güngör
 */
public class JSONObjectDeserializer extends StdDeserializer<JSONObject>
{
    private static final long serialVersionUID = 1L;

    public final static JSONObjectDeserializer instance = new JSONObjectDeserializer();

    public JSONObjectDeserializer()
    {
        super(org.json.JSONObject.class);
    }

    @Override
    public LogicalType logicalType() {
        return LogicalType.Untyped;
    }

    @Override
    public JSONObject deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException
    {
        JSONObject ob = new JSONObject();
        JsonToken t = p.getCurrentToken();
        if (t == JsonToken.START_OBJECT) {
            t = p.nextToken();
        }
        for (; t == JsonToken.FIELD_NAME; t = p.nextToken()) {
            String fieldName = p.getCurrentName();
            t = p.nextToken();
            try {
                switch (t) {
                    case START_ARRAY:
                        ob.put(fieldName, JSONArrayDeserializer.instance.deserialize(p, ctxt));
                        continue;
                    case START_OBJECT:
                        ob.put(fieldName, deserialize(p, ctxt));
                        continue;
                    case VALUE_STRING:
                        ob.put(fieldName, p.getText());
                        continue;
                    case VALUE_NULL:
                        ob.put(fieldName, org.json.JSONObject.NULL);
                        continue;
                    case VALUE_TRUE:
                        ob.put(fieldName, Boolean.TRUE);
                        continue;
                    case VALUE_FALSE:
                        ob.put(fieldName, Boolean.FALSE);
                        continue;
                    case VALUE_NUMBER_INT:
                        ob.put(fieldName, p.getNumberValue());
                        continue;
                    case VALUE_NUMBER_FLOAT:
                        ob.put(fieldName, p.getNumberValue());
                        continue;
                    case VALUE_EMBEDDED_OBJECT:
                        ob.put(fieldName, p.getEmbeddedObject());
                        continue;
                    default:
                }
            } catch (JSONException e) {
                throw ctxt.instantiationException(handledType(), e);
            }
            return (JSONObject) ctxt.handleUnexpectedToken(org.json.JSONObject.class, p);
        }
        return ob;
    }
}