package org.papaja.adminfly.module.mdbv.mongodb.common.query;

import org.papaja.adminfly.common.converter.Coders;
import org.papaja.adminfly.common.converter.Format;
import org.papaja.adminfly.common.util.function.Function;
import org.papaja.adminfly.common.util.function.Supplier;
import org.papaja.adminfly.common.util.structure.TriValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.papaja.adminfly.common.converter.Format.*;
import static org.papaja.adminfly.module.mdbv.mongodb.common.query.Filters.*;

@Component
@SuppressWarnings({"all"})
public class CriteriaHelper implements Supplier<Query> {

    private Query query;

    private static final Map<Filters, BiFunction<Criteria, Object, Criteria>> FILTERS_MAP;

    static {
        FILTERS_MAP = new EnumMap<>(Filters.class);
        FILTERS_MAP.put(EQ, (criteria, value) -> criteria.is(value));
        FILTERS_MAP.put(NE, (criteria, value) -> criteria.is(value));
        FILTERS_MAP.put(GT, (criteria, value) -> criteria.is(value));
        FILTERS_MAP.put(GTE, (criteria, value) -> criteria.is(value));
        FILTERS_MAP.put(LT, (criteria, value) -> criteria.is(value));
        FILTERS_MAP.put(LTE, (criteria, value) -> criteria.is(value));
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

    public void addFilters(String column, Format type, Object value, Filters filter) {
        query.addCriteria(createCriteria(column, type, value, filter));
    }

    public void addFilters(String column, TriValue<Format, Object, Filters> triValue) {
        addFilters(column, triValue.getA(), triValue.getB(), triValue.getC());
    }

    public void addFilters(Map<String, TriValue<Format, Object, Filters>> filters) {
        filters.forEach(this::addFilters);
    }

    public Criteria createCriteria(String column, Format type, Object value) {
        return createCriteria(column, type, value, EQ);
    }

    public Criteria createCriteria(String column, Format type, Object value, Filters filter) {
        Coders   coders   = Coders.INSTANCE;
        final Criteria criteria = Criteria.where(column);

        Map<Filters, Function<Object, Criteria>> filters

        filters.put(EQ, (v) -> criteria.is(v));

        filters.get(type).apply(value);

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

        FILTERS_MAP.get(type).apply(criteria, value);

        switch (filter) {
            case CONTAINS:
            case STARTS_WITH:
            case ENDS_WITH:

                String regex = null;

                switch (filter) {
                    case CONTAINS:
                        regex = ;
                        break;
                    case STARTS_WITH:
                        regex = ;
                        break;
                    case ENDS_WITH:
                        regex = ;
                        break;
                }

                criteria = criteria.regex();
                break;
            case IS_NULL:
                criteria = criteria.is(null);
                break;
            case NOT_NULL:
                criteria = criteria.ne(null);
                break;
        }

        System.out.println(filter);
        System.out.println(value);

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
