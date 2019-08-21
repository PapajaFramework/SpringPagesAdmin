package org.papaja.adminfly.module.mdbv.mongodb.repository;

import org.papaja.adminfly.module.mdbv.mongodb.document.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@SuppressWarnings({"unused"})
@Repository
public interface RecordRepository<T> extends MongoRepository<Record, String> {

    @Query("{ ?0 : ?1 }")
    Record findByDynamicField(String field, Object value);

}
