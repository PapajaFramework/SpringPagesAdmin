package org.papaja.adminfly.module.mdbv.mongodb.data.query;

import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.FilterTuple;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.PageTuple;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.SortTuple;
import org.papaja.commons.converter.Coders;
import org.papaja.commons.converter.Format;
import org.papaja.commons.data.query.Operator;
import org.papaja.commons.function.BiFunction;
import org.papaja.commons.function.Supplier;
import org.papaja.commons.function.TriFunction;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.max;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.papaja.commons.data.query.Operator.Comparison.*;
import static org.papaja.commons.data.query.Operator.Logical.AND;
import static org.papaja.commons.data.query.Operator.Logical.NONE;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
@SuppressWarnings({"all"})
public class QueryHelper implements Supplier<Query> {

    private static final Map<Operator.Comparison, TriFunction<Criteria, String, Criteria, Object>> FILTERS_MAP;
    private static final Map<Operator.Logical, BiFunction<Criteria, Criteria, String>>             LOGICAL_MAP;

    static {
        FILTERS_MAP = new EnumMap<>(Operator.Comparison.class);
        LOGICAL_MAP = new EnumMap<>(Operator.Logical.class);

        FILTERS_MAP.put(EQ, (column, criteria, value) -> criteria.is(value));
        FILTERS_MAP.put(NE, (column, criteria, value) -> criteria.ne(value));
        FILTERS_MAP.put(GT, (column, criteria, value) -> criteria.gt(value));
        FILTERS_MAP.put(GTE, (column, criteria, value) -> criteria.gte(value));
        FILTERS_MAP.put(LT, (column, criteria, value) -> criteria.lt(value));
        FILTERS_MAP.put(LTE, (column, criteria, value) -> criteria.lte(value));
        FILTERS_MAP.put(CONTAINS, (column, criteria, value) -> criteria.regex(format(".*%s.*", valueOf(value))));
        FILTERS_MAP.put(STARTS, (column, criteria, value) -> criteria.regex(format("^%s.*", valueOf(value))));
        FILTERS_MAP.put(ENDS, (column, criteria, value) -> criteria.regex(format(".*%s$", valueOf(value))));
        FILTERS_MAP.put(IS_NULL, (column, criteria, value) -> criteria.is(null));
        FILTERS_MAP.put(NOT_NULL, (column, criteria, value) -> criteria.ne(null));
        FILTERS_MAP.put(EMPTY, (column, criteria, value) -> new Criteria().orOperator(
            where(column).exists(true).size(0),
            where(column).is(Collections.EMPTY_MAP)
        ));
        FILTERS_MAP.put(NOT_EMPTY, (column, criteria, value) -> new Criteria().andOperator(
            where(column).ne(Collections.EMPTY_MAP),
            where(column).ne(Collections.EMPTY_LIST),
            where(column).ne(null)
        ));

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

    public Query add(Sort sort) {
        return query.with(sort);
    }

    public void page(PageTuple page) {
        add(PageRequest.of(max(page.getPage() - 1, 0), page.getCount()));
    }

    public void sort(List<SortTuple> tuples) {
        tuples.forEach(this::sort);
    }

    public void sort(SortTuple tuple) {
        add(new Sort(Direction.valueOf(tuple.getVector().toString()), tuple.getColumn()));
    }

    public void filters(List<FilterTuple> tuples) {
        Criteria criteria = null;

        for (FilterTuple tuple : tuples) {
            criteria = FILTERS_MAP.get(tuple.getComparison())
                    .apply(tuple.getPath(), criteria(criteria, tuple), value(tuple.getFormat(), tuple.getQuery()));
        }

        add(criteria);
    }

    private Criteria criteria(Criteria criteria, FilterTuple tuple) {
        return tuple.getLogical().equals(NONE)
                ? where(tuple.getPath())
                : LOGICAL_MAP.get(tuple.getLogical()).apply(criteria, tuple.getPath());
    }

    private <T> T value(Format format, Object value) {
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
