package org.papaja.commons.data.query;

public class Operator {

    public enum Comparison { EQ, NE, GT, GTE, LT, LTE, CONTAINS, STARTS, ENDS, IS_NULL, NOT_NULL, EMPTY, NOT_EMPTY }

    public enum Logical { NONE, AND, OR, XOR }

    public enum Sort { ASC, DESC }

}
