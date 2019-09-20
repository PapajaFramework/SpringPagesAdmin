package org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple;

import org.papaja.commons.structure.tuple.Pair;

import static java.util.Objects.nonNull;

public class PageTuple extends Pair<Integer, Integer> {

    public static final Integer DEFAULT_COUNT = 20;

    public PageTuple(Integer page, Integer count) {
        super(page, count);
    }

    public PageTuple() {
        this(0, DEFAULT_COUNT);
    }

    public Integer getPage() {
        return getA();
    }

    public void setPage(Integer page) {
        a = page;
    }

    public Integer getCount() {
        return getB();
    }

    public void setCount(Integer count) {
        b = count;
    }

    public boolean isValid() {
        return nonNull(a);
    }

    @Override
    public String toString() {
        return String.format("Page{a=%d, b=%s}", a, b);
    }
}
