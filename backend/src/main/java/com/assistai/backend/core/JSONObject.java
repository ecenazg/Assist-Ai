package com.assistai.backend.core;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

/**
 *
 * @author OTO Global
 */
public class JSONObject extends org.json.JSONObject
{

    public JSONObject() {
    }

    public JSONObject(org.json.JSONObject jo, String... names) {
        super(jo, names);
    }

    public JSONObject(Map<?, ?> m) {
        super(m);
    }

    public JSONObject(Object bean) {
        super(bean);
    }

    public JSONObject(Object object, String... names) {
        super(object, names);
    }

    public JSONObject(String baseName, Locale locale) throws JSONException {
        super(baseName, locale);
    }

    public JSONObject(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Gets the <code>double</code> value of the
     * field. If no data exists, <code>null</code>
     * is returned.
     *
     * @param key
     * @return
     */
    public Double asDouble(String key) {
        if (has(key)) {
            //The key exists. We will attempt
            //to get the exact value of this key.
            if (isNull(key))
                //The key exists but its value is
                //null. This is a special case that
                //is treated differently. We will
                //return a value of double with a
                //specific instance.
                return null;

            return getDouble(key);
        }

        //At this point, we know that the key
        //does not exist at all. We will simply
        //return null.
        return null;
    }

    /**
     * Gets the <code>long</code> value of the
     * field. If no data exists, <code>null</code>
     * is returned.
     *
     * @param key
     * @return
     */
    public Long asLong(String key) {
        if (has(key)) {
            //The key exists. We will attempt
            //to get the exact value of this key.
            if (isNull(key))
                //The key exists but its value is
                //null. This is a special case that
                //is treated differently. We will
                //return a value of double with a
                //specific instance.
                return null;

            return getLong(key);
        }

        //At this point, we know that the key
        //does not exist at all. We will simply
        //return null.
        return null;
    }

    /**
     * Gets the <code>int</code> value of the
     * field. If no data exists, <code>null</code>
     * is returned.
     *
     * @param key
     * @return
     */
    public Integer asInt(String key) {
        if (has(key)) {
            //The key exists. We will attempt
            //to get the exact value of this key.
            if (isNull(key))
                //The key exists but its value is
                //null. This is a special case that
                //is treated differently. We will
                //return a value of double with a
                //specific instance.
                return null;

            return getInt(key);
        }

        //At this point, we know that the key
        //does not exist at all. We will simply
        //return null.
        return null;
    }

    /**
     * Gets the <code>String</code> value of the
     * field. If no data exists, <code>null</code>
     * is returned.
     *
     * @param key
     * @return
     */
    public String asString(String key) {
        if (has(key)) {
            //The key exists. We will attempt
            //to get the exact value of this key.
            if (isNull(key))
                //The key exists but its value is
                //null. This is a special case that
                //is treated differently. We will
                //return a value of double with a
                //specific instance.
                return null;

            return getString(key);
        }

        //At this point, we know that the key
        //does not exist at all. We will simply
        //return null.
        return null;
    }

    /**
     * Gets the <code>JSONObject</code> value of the
     * field. If no data exists, <code>empty</code>
     * object is returned.
     *
     * @param key
     * @return
     */
    @Override
    public JSONObject optJSONObject(String key) {
        if (has(key) && !isNull(key))
            return getJSONObject(key);

        //At this point, we know that the key
        //does not exist at all. We will simply
        //return null.
        return new JSONObject();
    }

    /**
     * Gets the <code>boolean</code> value of the
     * field. If no data exists, <code>null</code>
     * is returned.
     *
     * @param key
     * @return
     */
    public Boolean asBoolean(String key) {
        if (has(key)) {
            //The key exists. We will attempt
            //to get the exact value of this key.
            if (isNull(key))
                //The key exists but its value is
                //null. This is a special case that
                //is treated differently. We will
                //return a value of double with a
                //specific instance.
                return null;

            return getBoolean(key);
        }

        //At this point, we know that the key
        //does not exist at all. We will simply
        //return null.
        return null;
    }

    @Override
    public JSONObject getJSONObject(String key) throws JSONException {
        return (JSONObject) super.getJSONObject(key);
    }

    @Override
    public JSONArray getJSONArray(String key) throws JSONException {
        return (JSONArray) super.getJSONArray(key);
    }

    @Override
    public JSONObject put(String key, Collection<?> value) throws JSONException {
        super.put(key, value);
        return this;
    }

    @Override
    public JSONObject put(String key, Map<?, ?> value) throws JSONException {
        super.put(key, value);
        return this;
    }

    @Override
    public JSONObject put(String key, Object value) throws JSONException {
        super.put(key, value);
        return this;
    }

    @Override
    public JSONObject put(String key, boolean value) throws JSONException {
        super.put(key, value);
        return this;
    }

    @Override
    public JSONObject put(String key, double value) throws JSONException {
        super.put(key, value);
        return this;
    }

    @Override
    public JSONObject put(String key, float value) throws JSONException {
        super.put(key, value);
        return this;
    }

    @Override
    public JSONObject put(String key, int value) throws JSONException {
        super.put(key, value);
        return this;
    }

    @Override
    public JSONObject put(String key, long value) throws JSONException {
        super.put(key, value);
        return this;
    }
}
