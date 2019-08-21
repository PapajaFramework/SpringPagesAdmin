package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvValuePath;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MdbvValuePathsRepository extends AbstractRepository<MdbvValuePath> {

    @Override
    public Class<MdbvValuePath> getReflection() {
        return MdbvValuePath.class;
    }

}
