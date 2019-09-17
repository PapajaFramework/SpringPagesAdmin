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

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.papaja.adminfly.common.converter.Format.*;

@Component
@SuppressWarnings({"all"})
public class QueryBuilder implements Supplier<Query> {

    private Query query;

    public QueryBuilder() {
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
        return createCriteria(column, type, value, Filters.EQ);
    }

    public Criteria createCriteria(String column, Format type, Object value, Filters filter) {
        Coders   coders   = Coders.INSTANCE;
        final Criteria criteria = Criteria.where(column);

        Map<Filters, Function<Object, Criteria>> filters = new EnumMap<>(Filters.class);

        filters.put(Filters.EQ, (v) -> criteria.is(v));

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

        switch (filter) {
            case EQ:
                criteria = criteria.is(value);
                break;
            case NE:
                criteria = criteria.ne(value);
                break;
            case GT:
                criteria = criteria.gt(value);
                break;
            case GTE:
                criteria = criteria.gte(value);
                break;
            case LT:
                criteria = criteria.lt(value);
                break;
            case LTE:
                criteria = criteria.lte(value);
                break;
            case CONTAINS:
            case STARTS_WITH:
            case ENDS_WITH:

                String regex = null;

                switch (filter) {
                    case CONTAINS:
                        regex = ".*%s.*";
                        break;
                    case STARTS_WITH:
                        regex = "^%s.*";
                        break;
                    case ENDS_WITH:
                        regex = ".*%s$";
                        break;
                }

                criteria = criteria.regex(format(regex, valueOf(value)));
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
