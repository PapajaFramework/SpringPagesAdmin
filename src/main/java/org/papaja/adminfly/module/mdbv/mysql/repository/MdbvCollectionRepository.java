package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvCollection;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MdbvCollectionRepository extends AbstractRepository<MdbvCollection> {

    @Override
    public Class<MdbvCollection> getReflection() {
        return MdbvCollection.class;
    }

}
