package org.papaja.adminfly.module.mdbv.mongodb.service;

import org.papaja.adminfly.common.util.function.Supplier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unused"})
public class RecordQueryService implements Supplier<Query> {

    private Query query;

    public RecordQueryService() {
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

    @Override
    public Query get() {
        return query;
    }

}
