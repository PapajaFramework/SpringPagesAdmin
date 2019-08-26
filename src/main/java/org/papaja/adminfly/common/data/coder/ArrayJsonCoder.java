package org.papaja.adminfly.common.data.coder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.papaja.adminfly.common.data.Coder;

abstract public class ArrayJsonCoder<T> implements Coder<T, String> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public T decode(String source) {
        T array = null;

        try{
            array = MAPPER.readValue(source, getArrayClass());
        } catch (Exception exception) {}

        return array;
    }

    @Override
    public String encode(T source) {
        String json = null;

        try{
            json = MAPPER.writeValueAsString(source);
        } catch (Exception exception) {}

        return json;
    }

    abstract public Class<T> getArrayClass();

}
