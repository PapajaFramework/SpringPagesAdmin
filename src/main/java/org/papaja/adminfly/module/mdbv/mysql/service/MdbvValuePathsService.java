package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.mysql.dto.ValuePathDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvValuePath;
import org.papaja.adminfly.module.mdbv.mysql.mapper.ValuePathMapper;
import org.papaja.adminfly.module.mdbv.mysql.repository.MdbvValuePathsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class MdbvValuePathsService {

    @Autowired
    private MdbvValuePathsRepository repository;

    @Autowired
    private ValuePathMapper mapper;

    public void save(ValuePathDto dto, MdbvValuePath entity) {
        mapper.map(dto, entity);

        merge(entity);
    }

    public void merge(MdbvValuePath entity) {
        repository.merge(entity);
    }

    public List<MdbvValuePath> getPaths() {
        return repository.getList();
    }

    public MdbvValuePath getPath(Integer id) {
        return repository.get(id);
    }

    public MdbvValuePath getPathOrNew(Integer id) {
        return nonNull(id) ?  getPath(id) : new MdbvValuePath();
    }

}
