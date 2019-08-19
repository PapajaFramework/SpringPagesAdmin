package org.papaja.adminfly.module.mdbv.repository;

import org.papaja.adminfly.module.mdbv.document.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@SuppressWarnings({"unused"})
@Repository
public interface RecordRepository extends MongoRepository<Record, BigInteger> {

    @Query("{ ?0 : ?1 }")
    Record findByDynamicField(String field, Object value);

}
