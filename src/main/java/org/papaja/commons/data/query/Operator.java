package org.papaja.commons.data.query;

import org.papaja.commons.structure.tuple.Pair;

import static org.papaja.commons.data.query.Operator.Logical.NONE;

public class Operator {

    public static Pair<Comparison, Logical> of(Comparison comparison, Logical logical) {
        return new Pair<>(comparison, logical);
    }

    public static Pair<Comparison, Logical> of(Comparison comparison) {
        return of(comparison, NONE);
    }

    public enum Comparison {
        EQ, NE, GT, GTE, LT, LTE, CONTAINS, STARTS, ENDS, IS_NULL, NOT_NULL, EMPTY, NOT_EMPTY
    }

    public enum Logical {
        NONE, AND, OR, XOR
    }

    public enum Sort {
        ASC, DESC
    }

}
