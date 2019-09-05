package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.mysql.entity.ScannedPath;
import org.papaja.adminfly.module.mdbv.mysql.repository.ScannedRepository;
import org.papaja.adminfly.shared.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScannedService extends AbstractService<ScannedPath, ScannedRepository> {

    @Autowired
    private ScannedRepository repository;

    @Override
    public ScannedRepository getRepository() {
        return repository;
    }

    @Override
    public ScannedPath get() {
        return new ScannedPath();
    }

}
