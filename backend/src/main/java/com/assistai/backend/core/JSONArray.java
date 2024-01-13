package com.assistai.backend.core;

import java.util.Collection;
import org.json.JSONException;
import org.json.JSONTokener;

public class JSONArray extends org.json.JSONArray {

    public JSONArray() {
    }

    public JSONArray(JSONTokener x) throws JSONException {
        super(x);
    }

    public JSONArray(String source) throws JSONException {
        super(source);
    }

    public JSONArray(Collection<?> collection) {
        super(collection);
    }

    public JSONArray(Iterable<?> iter) {
        super(iter);
    }

    public JSONArray(JSONArray array) {
        super(array);
    }

    public JSONArray(Object array) throws JSONException {
        super(array);
    }

    public JSONArray(int initialCapacity) throws JSONException {
        super(initialCapacity);
    }

    @Override
    public JSONObject getJSONObject(int index) throws JSONException {
        return (JSONObject)super.getJSONObject(index);
    }
}
