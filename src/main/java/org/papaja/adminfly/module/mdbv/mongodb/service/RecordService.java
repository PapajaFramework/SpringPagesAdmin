package org.papaja.adminfly.module.mdbv.mongodb.service;

import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.FilterTuple;
import org.papaja.adminfly.module.mdbv.common.manager.MongoDatabaseManager;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.PageTuple;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.SortTuple;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.QueryHelper;
import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.papaja.adminfly.module.mdbv.mysql.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.papaja.commons.converter.Format.RAW;
import static org.papaja.commons.data.query.Operator.Comparison.EQ;
import static org.papaja.commons.data.query.Operator.Logical.NONE;

@Service
@SuppressWarnings({"all"})
public class RecordService {

    public static final Integer DEFAULT_SIZE = 5;

    @Autowired
    private MongoDatabaseManager manager;

    @Autowired
    private SourceService service;

    @Autowired
    private QueryHelper helper;

    private MongoTemplate template() {
        return manager.getMongoTemplateForDatabase(database());
    }

    private String collection() {
        return service.getActiveSource().getCollection();
    }

    private String database() {
        return service.getActiveSource().getDatabase();
    }

    public Long count() {
        return count(collection());
    }

    public Long count(String collection) {
        return count(helper.get(), collection);
    }

    public Long count(Query query) {
        return count(query, collection());
    }

    public Long count(Query query, String collection) {
        return template().count(query, collection);
    }

    public Query getQuery(String id) {
        return getQuery(new FilterTuple("_id", id, RAW, EQ, NONE), new PageTuple(), new SortTuple());
    }

    public Query getQuery(FilterTuple filter, PageTuple page, SortTuple sort) {
        Query query = helper.get();

        if (filter.isValid()) {
            helper.filters(new ArrayList<FilterTuple>() {{ add(filter); }});
        }

        if (page.isValid()) {
            helper.page(page);
        }

        if (sort.isValid()) {
            helper.sort(sort);
        }

        return query;
    }

    public List<MapRecord> getRecords(String collection, Query query) {
        List<MapRecord> records = template().find(query, MapRecord.class, collection);

        helper.reset();

        return records;
    }

    public <T> T getRecord(String id, Class<T> reflection) {
        T record = template().findOne(getQuery(id), reflection, service.getActiveSource().getCollection());

        helper.reset();

        return record;
    }

    public MapRecord getRecord(String id) {
        return getRecord(id, MapRecord.class);
    }

    public String getJsonRecord(String id) {
        return getRecord(id, String.class);
    }

}
