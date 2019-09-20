package org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple;

import org.papaja.commons.converter.Format;
import org.papaja.commons.data.query.Operator.Comparison;
import org.papaja.commons.data.query.Operator.Logical;
import org.papaja.commons.structure.tuple.Quintet;

import static java.util.Objects.nonNull;

public class FilterTuple extends Quintet<String, Object, Format, Comparison, Logical> {

    public FilterTuple(String path, Object value, Format format, Comparison comparison, Logical logical) {
        super(path, value, format, comparison, logical);
    }

    public FilterTuple(String path, Object value, Format format, Comparison comparison) {
        super(path, value, format, comparison, Logical.NONE);
    }

    public FilterTuple() {
        this(null, null, Format.RAW, Comparison.EQ, Logical.NONE);
    }

    public String getPath() {
        return getA();
    }

    public Object getQuery() {
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

    public void setPath(String path) {
        a = path;
    }

    public void setQuery(Object value) {
        b = value;
    }

    public void setFormat(Format format) {
        c = format;
    }

    public void setComparison(Comparison comparison) {
        d = comparison;
    }

    public void setLogical(Logical logical) {
        e = logical;
    }

    public boolean isValid() {
        return nonNull(a);
    }

    @Override
    public String toString() {
        return String.format("Filter{a=%s, b=%s, c=%s, d=%s, e=%s}", a, b, c, d, e);
    }
}
