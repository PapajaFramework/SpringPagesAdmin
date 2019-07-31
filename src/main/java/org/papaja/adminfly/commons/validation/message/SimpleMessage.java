package org.papaja.adminfly.commons.validation.message;

import org.papaja.adminfly.commons.validation.Message;

import java.util.HashMap;

public final class SimpleMessage implements Message {

    private static final Cache CACHE;

    static {
        CACHE = new Cache();
    }

    public String message;

    public SimpleMessage(String message) {
        this.message = message;
    }

    public static Message of(String message) {
        Message violation;

        if (CACHE.containsKey(message)) {
            violation = CACHE.get(message);
        } else {
            violation = new SimpleMessage(message);

            if (CACHE.MAX_SIZE > CACHE.size()) {
                CACHE.put(message, violation);
            }
        }

        return violation;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private static class Cache extends HashMap<String, Message> {

        private static final int MAX_SIZE = 16;

        public Cache() {
            super(MAX_SIZE, 1F);
        }

    }

}
