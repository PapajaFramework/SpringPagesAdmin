package org.papaja.adminfly.common.converter;

import org.papaja.adminfly.common.converter.coder.*;

public enum Format {

    RAW(new NullCoder()),
    BASE64(new Base64Coder()),
    LIST(new ListCoder()),
    MAP(new MapCoder()),
    JAVA_DATE(new JavaDateCoder()),
    STRING(new QuotedStringCoder());

    private Coder coder;

    Format(Coder coder) {
        this.coder = coder;
    }

    public Coder getCoder() {
        return coder;
    }

}
