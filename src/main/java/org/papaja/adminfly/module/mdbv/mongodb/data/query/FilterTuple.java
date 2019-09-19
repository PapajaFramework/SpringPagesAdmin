package org.papaja.adminfly.module.mdbv.mongodb.data.query;

import org.papaja.commons.converter.Format;
import org.papaja.commons.data.query.Operator.Comparison;
import org.papaja.commons.data.query.Operator.Logical;
import org.papaja.commons.structure.tuple.Quintet;

public class FilterTuple extends Quintet<String, Object, Format, Comparison, Logical> {

    public FilterTuple(String column, Object value, Format format, Comparison comparison, Logical logical) {
        super(column, value, format, comparison, logical);
    }

    public FilterTuple(String column, Object value, Format format, Comparison comparison) {
        super(column, value, format, comparison, Logical.NONE);
    }

    public String getColumn() {
        return getA();
    }

    public Object getValue() {
        return getB();
    }

    public Format getFormat() {
        return getC();
    }

    public Comparison getComparison() {
        return getD();
    }

    public Logical getLogical() {
        return getE();
    }

    @Override
    public String toString() {
        return String.format("FilterTuple{a=%s, b=%s, c=%s, d=%s, e=%s}", a, b, c, d, e);
    }
}
