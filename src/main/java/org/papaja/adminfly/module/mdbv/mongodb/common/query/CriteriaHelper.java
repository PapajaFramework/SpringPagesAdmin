package org.papaja.adminfly.module.mdbv.mongodb.common.query;

import org.papaja.commons.converter.Coders;
import org.papaja.commons.converter.Format;
import org.papaja.commons.function.Supplier;
import org.papaja.commons.structure.tuple.Quartet;
import org.papaja.commons.structure.tuple.Triplet;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.papaja.commons.converter.Format.*;
import static org.papaja.adminfly.module.mdbv.mongodb.common.query.Filter.*;

@Component
@SuppressWarnings({"all"})
public class CriteriaHelper implements Supplier<Query> {

    private Query query;

    private static final Map<Filter, BiFunction<Criteria, Object, Criteria>> FILTERS_MAP;

    static {
        FILTERS_MAP = new EnumMap<>(Filter.class);
        FILTERS_MAP.put(EQ, (criteria, value) -> criteria.is(value));
        FILTERS_MAP.put(NE, (criteria, value) -> criteria.ne(value));
        FILTERS_MAP.put(GT, (criteria, value) -> criteria.gt(value));
        FILTERS_MAP.put(GTE, (criteria, value) -> criteria.gte(value));
        FILTERS_MAP.put(LT, (criteria, value) -> criteria.lt(value));
        FILTERS_MAP.put(LTE, (criteria, value) -> criteria.lte(value));
        FILTERS_MAP.put(CONTAINS, (criteria, value) -> criteria.regex(format(".*%s.*", valueOf(value))));
        FILTERS_MAP.put(STARTS_WITH, (criteria, value) -> criteria.regex(format("^%s.*", valueOf(value))));
        FILTERS_MAP.put(ENDS_WITH, (criteria, value) -> criteria.regex(format(".*%s$", valueOf(value))));
        FILTERS_MAP.put(IS_NULL, (criteria, value) -> criteria.is(null));
        FILTERS_MAP.put(NOT_NULL, (criteria, value) -> criteria.ne(null));
    }

    public CriteriaHelper() {
        reset();
    }

    public void reset() {
        query = new Query();
    }

    public void add(PageRequest request) {
        query.with(request);
    }

    public void add(Criteria criteria) {
        query.addCriteria(criteria);
    }

    public void addFilters(String column, Format type, Object value, Filter filter) {
        query.addCriteria(createCriteria(column, type, value, filter));
    }

    public void addFilters(String column, Triplet<Format, Object, Filter> triplet) {
        addFilters(column, triplet.getA(), triplet.getB(), triplet.getC());
    }

    public void addFilters(Map<String, Triplet<Format, Object, Filter>> filters) {
        filters.forEach(this::addFilters);
    }

    public Criteria createCriteria(String column, Format type, Object value) {
        return createCriteria(column, type, value, EQ);
    }

    public Criteria createCriteria(List<Quartet<String, Object, Format, Filter>> quartets) {
        Criteria criteria = null;

        for (Quartet<String, Object, Format, Filter> quartet : quartets) {
            criteria = createCriteria(quartet);
        }

        return criteria;
    }

    public Criteria createCriteria(Quartet<String, Object, Format, Filter> quartet) {
        return createCriteria(quartet.getA(), quartet.getC(), quartet.getB(), quartet.getD());
    }

    public Criteria createCriteria(String column, Format type, Object value, Filter filter) {
        Coders   coders   = Coders.INSTANCE;
        Criteria criteria = Criteria.where(column);

        switch (type) {
            case STRING:
                value = coders.get(STRING).decode(value);
                break;
            case JAVA_DATE:
                value = coders.get(JAVA_DATE).decode(value);
                break;
            case MAP:
            case LIST:
                value = coders.get(type).decode(value);
                break;
        }

        criteria = FILTERS_MAP.get(filter).apply(criteria, value);

        return criteria;
    }

    @Override
    public Query get() {
        return query;
    }

    public Query getQuery() {
        return query;
    }
}
