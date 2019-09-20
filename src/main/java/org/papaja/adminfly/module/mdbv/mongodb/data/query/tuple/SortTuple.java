package org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple;

import org.papaja.commons.data.query.Operator;
import org.papaja.commons.structure.tuple.Pair;

import java.util.Objects;

import static java.util.Objects.nonNull;

public class SortTuple extends Pair<String, Operator.Sort> {

    public SortTuple(String column, Operator.Sort vector) {
        super(column, vector);
    }

    public SortTuple() {
        this(null, Operator.Sort.ASC);
    }

    public String getColumn() {
        return getA();
    }

    public Operator.Sort getVector() {
        return getB();
    }

    public void setColumn(String column) {
        a = column;
    }

    public void setVector(Operator.Sort vector) {
        b = vector;
    }

    public boolean isValid() {
        return nonNull(a);
    }

    @Override
    public String toString() {
        return String.format("Sort{a=%s, b=%s}", a, b);
    }

}
