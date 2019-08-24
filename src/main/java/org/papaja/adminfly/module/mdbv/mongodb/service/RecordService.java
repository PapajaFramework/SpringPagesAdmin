package org.papaja.adminfly.module.mdbv.mongodb.service;

import org.papaja.adminfly.module.mdbv.common.manager.MongoDatabaseManager;
import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.papaja.adminfly.module.mdbv.mysql.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    public static final Integer DEFAULT_SIZE = 5;

    @Autowired
    private MongoDatabaseManager manager;

    @Autowired
    private SourceService service;

    public Long count() {
        return count(service.getActiveSource().getCollection());
    }

    public Long count(String collection) {
        return template().count(new Query(), collection);
    }

    private MongoTemplate template() {
        return manager.getMongoTemplateForDatabase(service.getActiveSource().getDatabase());
    }

    public List<MapRecord> getRecords(Integer number, String collection) {
        return getRecords(number, DEFAULT_SIZE, collection);
    }

    public List<MapRecord> getRecords(Integer number, Integer size, String collection) {
        return template().find(new Query().with(PageRequest.of(number, size)), MapRecord.class, collection);
    }

    public List<MapRecord> getRecords(Integer number, Integer size) {
        return getRecords(number, size, service.getActiveSource().getCollection());
    }

    public List<MapRecord> getRecords(Integer number) {
        return getRecords(number, DEFAULT_SIZE, service.getActiveSource().getCollection());
    }

    public List<MapRecord> getRecords() {
        return getRecords(0, DEFAULT_SIZE, service.getActiveSource().getCollection());
    }

    public Query getQueryFor(String column, Object value) {
        return new Query().addCriteria(Criteria.where(column).is(value));
    }

    public <T> T getRecord(String id, Class<T> reflection) {
        return template().findOne(getQueryFor("_id", id), reflection, service.getActiveSource().getCollection());
    }

    public MapRecord getRecord(String id) {
        return getRecord(id, MapRecord.class);
    }

    public String getJsonRecord(String id) {
        return getRecord(id, String.class);
    }

}
