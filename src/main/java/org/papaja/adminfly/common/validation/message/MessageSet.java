package org.papaja.adminfly.common.validation.message;

import org.papaja.adminfly.common.validation.Message;

public enum MessageSet implements Message {

    IS_NULL("must be NULL"),
    NOT_NULL("must be NOT NULL");

    private String message;

    MessageSet(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
