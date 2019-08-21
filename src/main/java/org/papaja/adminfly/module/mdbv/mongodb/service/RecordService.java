package org.papaja.adminfly.module.mdbv.mongodb.service;

import org.papaja.adminfly.module.mdbv.mongodb.document.Record;
import org.papaja.adminfly.module.mdbv.mongodb.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    public static final Integer SIZE = 5;

    @Autowired
    private RecordRepository repository;

    public List<Record> getRecords(Integer number) {
        Pageable     request = PageRequest.of(number, SIZE);
        Page<Record> page    = repository.findAll(request);

        return page.getContent();
    }

}
