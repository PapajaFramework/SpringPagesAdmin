package org.papaja.adminfly.module.mdbv.mongodb.service;

import org.papaja.adminfly.common.converter.Coders;
import org.papaja.adminfly.common.converter.Format;
import org.papaja.adminfly.common.util.structure.BiValue;
import org.papaja.adminfly.module.mdbv.common.manager.MongoDatabaseManager;
import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.papaja.adminfly.module.mdbv.mysql.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.papaja.adminfly.common.converter.Format.JAVA_DATE;
import static org.papaja.adminfly.common.converter.Format.RAW;

@Service
public class RecordService {

    public static final Integer DEFAULT_SIZE = 5;

    @Autowired
    private MongoDatabaseManager manager;

    @Autowired
    private SourceService service;

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
        return count(createQuery(), collection);
    }

    public Long count(Query query) {
        return count(query, collection());
    }

    public Long count(Query query, String collection) {
        return template().count(query, collection);
    }

    public List<MapRecord> getRecords(String collection, String column, Format type, Object value, Integer number, Integer size) {
        Query                                query   = createQuery();
        PageRequest                          request = PageRequest.of(number, size);
        Map<String, BiValue<Format, Object>> filters = new HashMap<>();

        filters.put(column, new BiValue<>(type, value));

        query.addCriteria(createCriteria(column, type, value));
        query.with(request);

        return getRecords(collection, query);
    }

    public List<MapRecord> getRecords(String collection, Integer number, Integer size) {
        Query       query   = createQuery();
        PageRequest request = PageRequest.of(number, size);

        query.with(request);

        return getRecords(collection, query);
    }


    public List<MapRecord> getRecords(String collection, Query query) {
        return template().find(query, MapRecord.class, collection);
    }

    public List<MapRecord> getRecords(String collection, Integer number, Integer size) {
        return getRecords(collection, new Query(), number, size);
    }

    public List<MapRecord> getRecords(Integer number, Integer size) {
        return getRecords(service.getActiveSource().getCollection(), number, size);
    }

    public List<MapRecord> getRecords(Integer number) {
        return getRecords(service.getActiveSource().getCollection(), number, DEFAULT_SIZE);
    }

    public List<MapRecord> getRecords() {
        return getRecords(service.getActiveSource().getCollection(), 0, DEFAULT_SIZE);
    }

    public Query createQuery() {
        return new Query();
    }

    public Query createQuery(String column, Format type, Object value) {
        return createQuery().addCriteria(createCriteria(column, type, value));
    }

    public Criteria createCriteria(String column, Format type, Object value) {
        Coders coders = Coders.INSTANCE;

        switch (type) {
            case JAVA_DATE:
                value = coders.get(JAVA_DATE).decode(value);
                System.out.println(value);
                System.out.println(value.getClass().getName());
                break;
        }

        return Criteria.where(column).is(value);
    }

    public Criteria createCriteria(String column, Object value) {
        return createCriteria(column, RAW, value);
    }

    public <T> T getRecord(String id, Class<T> reflection) {
        return template().findOne(createQuery("_id", RAW, id), reflection, service.getActiveSource().getCollection());
    }

    public MapRecord getRecord(String id) {
        return getRecord(id, MapRecord.class);
    }

    public String getJsonRecord(String id) {
        return getRecord(id, String.class);
    }

}
