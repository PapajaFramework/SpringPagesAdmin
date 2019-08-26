package org.papaja.adminfly.common.converter.coder;

import org.papaja.adminfly.common.converter.Coder;

public class NullCoder implements Coder<Object, Object> {

    @Override
    public Object decode(Object source) {
        return source;
    }

    @Override
    public Object encode(Object source) {
        return source;
    }

}
