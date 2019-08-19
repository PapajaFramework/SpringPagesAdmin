package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.ValuePaths;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ValuePathsRepository extends AbstractRepository<ValuePaths> {

    @Override
    public Class<ValuePaths> getReflection() {
        return ValuePaths.class;
    }

}
