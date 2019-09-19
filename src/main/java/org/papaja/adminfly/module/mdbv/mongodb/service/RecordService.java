package org.papaja.adminfly.module.mdbv.mongodb.service;

import org.papaja.adminfly.module.mdbv.mongodb.data.query.FilterTuple;
import org.papaja.commons.converter.Format;
import org.papaja.commons.structure.tuple.Triplet;
import org.papaja.adminfly.module.mdbv.common.manager.MongoDatabaseManager;
import org.papaja.commons.data.query.Operator;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.QueryHelper;
import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.papaja.adminfly.module.mdbv.mysql.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.papaja.commons.converter.Format.RAW;
import static org.papaja.commons.data.query.Operator.Comparison.EQ;

@Service
@SuppressWarnings({"unused"})
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

    public List<MapRecord> getRecords(String collection, Query query) {
        List<MapRecord> records = template().find(query, MapRecord.class, collection);

        helper.reset();

        return records;
    }

    public List<MapRecord> getRecords(Integer number, Integer size) {
        return getRecords(collection(), getQuery(number, size));
    }

    public List<MapRecord> getRecords(Integer number) {
        return getRecords(collection(), getQuery(number, DEFAULT_SIZE));
    }

    public List<MapRecord> getRecords() {
        return getRecords(collection(), getQuery(0, DEFAULT_SIZE));
    }

    public Query getQuery(String column, Format type, Object value, Operator.Comparison filter, Integer number, Integer size) {
        helper.add(PageRequest.of(number, size));

//        helper.createCriteria(new ArrayList<FilterTuple>() {{
//            add(new FilterTuple(column, value, type, filter, Operator.Logical.NONE));
//            add(new FilterTuple(column, value, type, filter, Operator.Logical.AND));
//            add(new FilterTuple(column, value, type, filter, Operator.Logical.OR));
//        }});

        helper.addFilters(new HashMap<String, Triplet<Format, Object, Operator.Comparison>>() {{
            put(column, new Triplet<>(type, value, filter));
        }});

        return helper.get();
    }

    public Query getQuery(Integer number, Integer size) {
        helper.add(PageRequest.of(number, size));

        return helper.get();
    }

    public Query getQuery(String id) {
        helper.addFilters(new HashMap<String, Triplet<Format, Object, Operator.Comparison>>() {{
            put("_id", new Triplet<>(RAW, id, EQ));
        }});

        return helper.get();
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
