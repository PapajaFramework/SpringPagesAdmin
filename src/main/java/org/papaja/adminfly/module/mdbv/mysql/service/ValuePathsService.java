package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.mysql.dto.ValuePathDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.ValuePath;
import org.papaja.adminfly.module.mdbv.mysql.mapper.ValuePathMapper;
import org.papaja.adminfly.module.mdbv.mysql.repository.ValuePathsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class ValuePathsService {

    @Autowired
    private ValuePathsRepository repository;

    @Autowired
    private ValuePathMapper mapper;

    public void save(ValuePathDto dto, ValuePath entity) {
        mapper.map(dto, entity);

        merge(entity);
    }

    public void merge(ValuePath entity) {
        repository.merge(entity);
    }

    public List<ValuePath> getPaths() {
        return repository.getList();
    }

    public ValuePath getPath(Integer id) {
        return repository.get(id);
    }

    public ValuePath getPathOrNew(Integer id) {
        return nonNull(id) ?  getPath(id) : new ValuePath();
    }

}
