package org.papaja.adminfly.common.data;

import org.papaja.adminfly.common.data.coder.Base64;
import org.papaja.adminfly.common.data.coder.JavaDate;

public enum Format {

//    RAW,
    BASE64(new Base64()),
//    LIST,
//    MAP,
    JAVA_DATE(new JavaDate());

    private Coder coder;

    Format(Coder coder) {
        this.coder = coder;
    }

    public Coder getCoder() {
        return coder;
    }

}
