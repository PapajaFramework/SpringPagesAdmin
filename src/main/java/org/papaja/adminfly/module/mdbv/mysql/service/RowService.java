package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.mysql.entity.Row;
import org.papaja.adminfly.module.mdbv.mysql.repository.RowRepository;
import org.papaja.adminfly.shared.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RowService extends AbstractService<Row, RowRepository> {

    @Autowired
    private RowRepository repository;

    @Override
    public RowRepository getRepository() {
        return repository;
    }

    @Override
    public Row get() {
        throw new UnsupportedOperationException();
    }

}
