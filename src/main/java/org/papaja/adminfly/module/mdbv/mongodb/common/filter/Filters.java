package org.papaja.adminfly.module.mdbv.mongodb.common.filter;

public enum Filters {

    EQUAL(0x01),
    GT(0x02), GTE(0x03),
    LT(0x04), LTE(0x05),
    NE(0x06),
    CONTAINS(0x07);

    private byte value;

    Filters(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return value;
    }

}
