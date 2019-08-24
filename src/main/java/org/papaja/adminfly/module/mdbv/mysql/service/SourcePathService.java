package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.mysql.dto.SourcePathDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.Source;
import org.papaja.adminfly.module.mdbv.mysql.entity.SourcePath;
import org.papaja.adminfly.module.mdbv.mysql.mapper.SourcePathMapper;
import org.papaja.adminfly.module.mdbv.mysql.repository.SourcePathRepository;
import org.papaja.adminfly.shared.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SourcePathService extends AbstractService<SourcePath, SourcePathRepository> {

    @Autowired
    private SourcePathRepository repository;

    @Autowired
    private SourceService service;

    @Autowired
    private SourcePathMapper mapper;

    public void save(SourcePathDto dto, SourcePath entity) {
        mapper.map(dto, entity);

        entity.setSource(service.getActiveSource());

        merge(entity);
    }

    public List<SourcePath> getPaths() {
        return getAll();
    }

    public List<SourcePath> getPaths(Source source) {
        return getAll("source", source);
    }

    public SourcePath getPath(Integer id) {
        return getOne(id);
    }

    @Override
    public SourcePathRepository getRepository() {
        return repository;
    }

    @Override
    public SourcePath get() {
        return new SourcePath();
    }

}
