package org.papaja.adminfly.module.mdbv.mysql.service;

import org.papaja.adminfly.module.mdbv.common.holder.MdbvCollectionNameHolder;
import org.papaja.adminfly.module.mdbv.mysql.dto.CollectionDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvCollection;
import org.papaja.adminfly.module.mdbv.mysql.mapper.CollectionMapper;
import org.papaja.adminfly.module.mdbv.mysql.repository.MdbvCollectionRepository;
import org.papaja.adminfly.shared.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MdbvCollectionService extends AbstractService<MdbvCollection, MdbvCollectionRepository> {

    @Autowired
    private MdbvCollectionRepository repository;

    @Autowired
    private MdbvCollectionNameHolder holder;

    @Autowired
    private CollectionMapper mapper;

    public void remove(Integer id) {
        remove(getOne(id));
    }

    public void remove(MdbvCollection entity) {
        repository.remove(entity);
    }

    public boolean hasActiveCollection() {
        return holder.has();
    }

    public void setActiveCollection(Integer collectionId) {
        holder.set(collectionId);
    }

    public MdbvCollection getActiveCollection() {
        return getOne(holder.get());
    }

    public void save(CollectionDto dto, MdbvCollection entity) {
        mapper.map(dto, entity);

        repository.merge(entity);
    }

    @Override
    public MdbvCollectionRepository getRepository() {
        return repository;
    }

    @Override
    public MdbvCollection get() {
        return new MdbvCollection();
    }

}
