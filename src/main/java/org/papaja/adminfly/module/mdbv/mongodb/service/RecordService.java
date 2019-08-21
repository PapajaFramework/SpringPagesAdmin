package org.papaja.adminfly.module.mdbv.mongodb.service;

import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    public static final Integer DEFAULT_SIZE            = 5;
    public static final String  DEFAULT_COLLECTION_NAME = "records";

    @Autowired
    private MongoTemplate template;

    public Long count() {
        return count(DEFAULT_COLLECTION_NAME);
    }

    public Long count(String collection) {
        return template.count(new Query(), collection);
    }

    public List<MapRecord> getRecords(Integer number, String collection) {
        return getRecords(number, DEFAULT_SIZE, collection);
    }

    public List<MapRecord> getRecords(Integer number, Integer size) {
        return getRecords(number, size, DEFAULT_COLLECTION_NAME);
    }

    public List<MapRecord> getRecords(Integer number) {
        return getRecords(number, DEFAULT_SIZE, DEFAULT_COLLECTION_NAME);
    }

    public List<MapRecord> getRecords() {
        return getRecords(0, DEFAULT_SIZE, DEFAULT_COLLECTION_NAME);
    }

    public List<MapRecord> getRecords(Integer number, Integer size, String collection) {
        return template.find(new Query().with(PageRequest.of(number, size)), MapRecord.class, collection);
    }

}
