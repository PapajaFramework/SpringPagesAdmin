package org.papaja.adminfly.module.mdbv.mongodb.common.qb;

import org.papaja.adminfly.common.converter.Coders;
import org.papaja.adminfly.common.converter.Format;
import org.papaja.adminfly.common.util.function.Supplier;
import org.papaja.adminfly.common.util.structure.BiValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.papaja.adminfly.common.converter.Format.JAVA_DATE;
import static org.papaja.adminfly.common.converter.Format.STRING;

@Component
@SuppressWarnings({"all"})
public class MongoDBQueryBuilder implements Supplier<Query> {

    private Query query;

    public MongoDBQueryBuilder() {
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

    public void addFilters(String column, Format type, Object value) {
        query.addCriteria(createCriteria(column, type, value));
    }

    public void addFilters(String column, BiValue<Format, Object> biValue) {
        addFilters(column, biValue.getA(), biValue.getB());
    }

    public void addFilters(Map<String, BiValue<Format, Object>> filters) {
        filters.forEach(this::addFilters);
    }

    public Criteria createCriteria(String column, Format type, Object value) {
        Coders coders = Coders.INSTANCE;

        switch (type) {
            case STRING:
                value = coders.get(STRING).decode(value);
                break;
            case JAVA_DATE:
                value = coders.get(JAVA_DATE).decode(value);
                break;
        }

        return Criteria.where(column).is(value);
    }

    @Override
    public Query get() {
        return query;
    }

    public Query getQuery() {
        return query;
    }
}
