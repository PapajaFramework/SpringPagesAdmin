package org.papaja.adminfly.module.mdbv.mongodb.data.query;

import org.papaja.commons.converter.Coders;
import org.papaja.commons.converter.Format;
import org.papaja.commons.data.query.Operator;
import org.papaja.commons.function.BiFunction;
import org.papaja.commons.function.Supplier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.papaja.commons.data.query.Operator.Comparison.*;
import static org.papaja.commons.data.query.Operator.Logical.AND;
import static org.papaja.commons.data.query.Operator.Logical.NONE;

@Component
@SuppressWarnings({"all"})
public class QueryHelper implements Supplier<Query> {

    private static final Map<Operator.Comparison, BiFunction<Criteria, Criteria, Object>> FILTERS_MAP;
    private static final Map<Operator.Logical, BiFunction<Criteria, Criteria, String>>    LOGICAL_MAP;

    static {
        FILTERS_MAP = new EnumMap<>(Operator.Comparison.class);
        LOGICAL_MAP = new EnumMap<>(Operator.Logical.class);

        FILTERS_MAP.put(EQ, (criteria, value) -> criteria.is(value));
        FILTERS_MAP.put(NE, (criteria, value) -> criteria.ne(value));
        FILTERS_MAP.put(GT, (criteria, value) -> criteria.gt(value));
        FILTERS_MAP.put(GTE, (criteria, value) -> criteria.gte(value));
        FILTERS_MAP.put(LT, (criteria, value) -> criteria.lt(value));
        FILTERS_MAP.put(LTE, (criteria, value) -> criteria.lte(value));
        FILTERS_MAP.put(CONTAINS, (criteria, value) -> criteria.regex(format(".*%s.*", valueOf(value))));
        FILTERS_MAP.put(STARTS, (criteria, value) -> criteria.regex(format("^%s.*", valueOf(value))));
        FILTERS_MAP.put(ENDS, (criteria, value) -> criteria.regex(format(".*%s$", valueOf(value))));
        FILTERS_MAP.put(IS_NULL, (criteria, value) -> criteria.is(null));
        FILTERS_MAP.put(NOT_NULL, (criteria, value) -> criteria.ne(null));

        LOGICAL_MAP.put(AND, (criteria, column) -> criteria.and(column));
    }

    private Query query;

    public QueryHelper() {
        reset();
    }

    public void reset() {
        query = new Query();
    }

    public Query add(PageRequest request) {
        return query.with(request);
    }

    public Query add(Criteria criteria) {
        return query.addCriteria(criteria);
    }

    public Criteria filters(List<FilterTuple> tuples) {
        Criteria criteria = null;

        for (FilterTuple tuple : tuples) {
            criteria = filter(criteria(criteria, tuple), tuple);
        }

        System.out.println(criteria.getCriteriaObject().toJson());

        return criteria;
    }

    public Criteria filter(Criteria criteria, FilterTuple tuple) {
        return FILTERS_MAP.get(tuple.getComparison()).apply(criteria, value(tuple.getFormat(), tuple.getValue()));
    }

    public Criteria criteria(Criteria criteria, FilterTuple tuple) {
        return tuple.getLogical().equals(NONE) ? Criteria.where(tuple.getColumn()) : logical(criteria, tuple);
    }

    public Criteria logical(Criteria criteria, FilterTuple tuple) {
        // todo: not applicable only AND operator
        return LOGICAL_MAP.get(tuple.getLogical()).apply(criteria, tuple.getColumn());
    }

    public <T> T value(Format format, Object value) {
        switch (format) {
            case STRING:
            case JAVA_DATE:
            case MAP:
            case LIST:
                value = Coders.INSTANCE.get(format).decode(value);
                break;
        }

        return (T) value;
    }

    @Override
    public Query get() {
        return query;
    }

    public Query getQuery() {
        return query;
    }
}
