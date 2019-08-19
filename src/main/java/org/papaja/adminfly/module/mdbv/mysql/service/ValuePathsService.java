package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.mysql.entity.ValuePaths;
import org.papaja.adminfly.module.mdbv.mysql.repository.ValuePathsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ValuePathsService {

    @Autowired
    private ValuePathsRepository repository;

    public List<ValuePaths> getPaths() {
        return repository.getList();
    }

}
