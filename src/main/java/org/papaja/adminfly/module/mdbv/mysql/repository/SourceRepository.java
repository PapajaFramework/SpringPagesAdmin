package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.Source;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SourceRepository extends AbstractRepository<Source> {

    @Override
    public Class<Source> getReflection() {
        return Source.class;
    }

}
