package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvCollection;
import org.papaja.adminfly.module.mdbv.mysql.repository.MdbvCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MdbvCollectionService {

    @Autowired
    private MdbvCollectionRepository repository;

    public MdbvCollection getOne(Integer id) {
        return repository.get(id);
    }

    public List<MdbvCollection> getAll() {
        return repository.getList();
    }

}
