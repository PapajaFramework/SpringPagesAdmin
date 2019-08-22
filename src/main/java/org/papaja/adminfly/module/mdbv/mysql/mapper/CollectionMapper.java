package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.adminfly.common.util.Mapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.CollectionDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvCollection;
import org.springframework.stereotype.Component;

@Component
public class CollectionMapper implements Mapper<CollectionDto, MdbvCollection> {

    @Override
    public void map(CollectionDto source, MdbvCollection target) {
        target.setName(source.getName());
        target.setCollection(source.getCollection());
    }

    @Override
    public MdbvCollection get() {
        return new MdbvCollection();
    }

}
