package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.ValuePath;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ValuePathsRepository extends AbstractRepository<ValuePath> {

    @Override
    public Class<ValuePath> getReflection() {
        return ValuePath.class;
    }

}
