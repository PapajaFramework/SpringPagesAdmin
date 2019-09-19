package org.papaja.adminfly.module.mdbv.mongodb.data.query;

import org.papaja.commons.converter.Coders;
import org.papaja.commons.converter.Format;
import org.papaja.commons.data.query.Operator;
import org.papaja.commons.function.Supplier;
import org.papaja.commons.structure.tuple.Quartet;
import org.papaja.commons.structure.tuple.Triplet;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.papaja.commons.data.query.Operator.Comparison.*;

@Component
@SuppressWarnings({"all"})
public class QueryHelper implements Supplier<org.springframework.data.mongodb.core.query.Query> {

    private org.springframework.data.mongodb.core.query.Query query;

    private static final Map<Operator.Comparison, BiFunction<Criteria, Object, Criteria>> FILTERS_MAP;

    static {
        FILTERS_MAP = new EnumMap<>(Operator.Comparison.class);
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
    }

    public QueryHelper() {
        reset();
    }

    public void reset() {
        query = new org.springframework.data.mongodb.core.query.Query();
    }

    public void add(PageRequest request) {
        query.with(request);
    }

    public void add(Criteria criteria) {
        query.addCriteria(criteria);
    }

    public void addFilters(String column, Format type, Object value, Operator.Comparison filter) {
        query.addCriteria(createCriteria(column, type, value, filter));
    }

    public void addFilters(String column, Triplet<Format, Object, Operator.Comparison> triplet) {
        addFilters(column, triplet.getA(), triplet.getB(), triplet.getC());
    }

    public void addFilters(Map<String, Triplet<Format, Object, Operator.Comparison>> filters) {
        filters.forEach(this::addFilters);
    }

    public Criteria createCriteria(String column, Format type, Object value) {
        return createCriteria(column, type, value, EQ);
    }

    public Criteria createCriteria(List<FilterTuple> tuples) {
        Criteria criteria = null;

        for (FilterTuple tuple : tuples) {

            if (tuple.getLogical().equals(Operator.Logical.NONE)) {
                criteria = Criteria.where(tuple.getColumn());
            } else {
                criteria.and(tuple.getColumn());
            }

            BiFunction<Criteria, Object, Criteria> filter = FILTERS_MAP.get(tuple.getComparison());

            criteria = criteria = filter.apply(criteria, convertValue(tuple.getFormat(), tuple.getValue()));
        }

        return criteria;
    }

    public Criteria createCriteria(Quartet<String, Object, Format, Operator.Comparison> quartet) {
        return createCriteria(quartet.getA(), quartet.getC(), quartet.getB(), quartet.getD());
    }

    public Criteria createCriteria(String column, Format type, Object value, Operator.Comparison filter) {
        Criteria criteria = Criteria.where(column);

        criteria = FILTERS_MAP.get(filter).apply(criteria, convertValue(type, value));

        return criteria;
    }

    public <T> T convertValue(Format format, Object value) {
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
    public org.springframework.data.mongodb.core.query.Query get() {
        return query;
    }

    public org.springframework.data.mongodb.core.query.Query getQuery() {
        return query;
    }
}
