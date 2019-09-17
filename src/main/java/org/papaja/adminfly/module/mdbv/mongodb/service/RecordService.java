package org.papaja.adminfly.module.mdbv.mongodb.service;

import org.papaja.adminfly.common.converter.Format;
import org.papaja.adminfly.common.util.structure.TriValue;
import org.papaja.adminfly.module.mdbv.common.manager.MongoDatabaseManager;
import org.papaja.adminfly.module.mdbv.mongodb.common.query.Filters;
import org.papaja.adminfly.module.mdbv.mongodb.common.query.QueryBuilder;
import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.papaja.adminfly.module.mdbv.mysql.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static org.papaja.adminfly.common.converter.Format.RAW;
import static org.papaja.adminfly.module.mdbv.mongodb.common.query.Filters.EQ;

@Service
@SuppressWarnings({"unused"})
public class RecordService {

    public static final Integer DEFAULT_SIZE = 5;

    @Autowired
    private MongoDatabaseManager manager;

    @Autowired
    private SourceService service;

    @Autowired
    private QueryBuilder builder;

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
        return count(builder.get(), collection);
    }

    public Long count(Query query) {
        return count(query, collection());
    }

    public Long count(Query query, String collection) {
        return template().count(query, collection);
    }

    public List<MapRecord> getRecords(String collection, Query query) {
        List<MapRecord> records = template().find(query, MapRecord.class, collection);

        builder.reset();

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

    public Query getQuery(String column, Format type, Object value, Filters filter, Integer number, Integer size) {
        builder.add(PageRequest.of(number, size));

        builder.addFilters(new HashMap<String, TriValue<Format, Object, Filters>>() {{
            put(column, new TriValue<>(type, value, filter));
        }});

        return builder.get();
    }

    public Query getQuery(Integer number, Integer size) {
        builder.add(PageRequest.of(number, size));

        return builder.get();
    }

    public Query getQuery(String id) {
        builder.addFilters(new HashMap<String, TriValue<Format, Object, Filters>>() {{
            put("_id", new TriValue<>(RAW, id, EQ));
        }});

        return builder.get();
    }

    public <T> T getRecord(String id, Class<T> reflection) {
        T record = template().findOne(getQuery(id), reflection, service.getActiveSource().getCollection());

        builder.reset();

        return record;
    }

    public MapRecord getRecord(String id) {
        return getRecord(id, MapRecord.class);
    }

    public String getJsonRecord(String id) {
        return getRecord(id, String.class);
    }

}
