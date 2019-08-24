package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.common.holder.SourceIdHolder;
import org.papaja.adminfly.module.mdbv.mysql.dto.SourceDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.Source;
import org.papaja.adminfly.module.mdbv.mysql.mapper.SourceMapper;
import org.papaja.adminfly.module.mdbv.mysql.repository.SourceRepository;
import org.papaja.adminfly.shared.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SourceService extends AbstractService<Source, SourceRepository> {

    @Autowired
    private SourceRepository repository;

    @Autowired
    private SourceIdHolder holder;

    @Autowired
    private SourceMapper mapper;

    private Source currentSource;

    public boolean hasActiveSource() {
        return holder.has();
    }

    public void setActiveSource(Integer sourceId) {
        holder.set(sourceId);

        currentSource = getOne(holder.get());
    }

    public Source getActiveSource() {
        return currentSource;
    }

    public void save(SourceDto dto, Source entity) {
        mapper.map(dto, entity);

        repository.merge(entity);
    }

    @Override
    public SourceRepository getRepository() {
        return repository;
    }

    @Override
    public Source get() {
        return new Source();
    }

}
