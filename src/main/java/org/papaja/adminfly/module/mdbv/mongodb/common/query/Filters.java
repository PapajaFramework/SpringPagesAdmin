package org.papaja.adminfly.module.mdbv.mongodb.common.query;

public enum Filters {

    EQ(0x01), NE(0x02),
    GT(0x03), GTE(0x04),
    LT(0x05), LTE(0x06),
    CONTAINS(0x07),
    STARTS_WITH(0x08),
    ENDS_WITH(0x09),
    IS_NULL(0x10), NOT_NULL(0X11);

    private byte value;

    Filters(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return value;
    }

}
