package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.ScannedPath;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ScannedRepository extends AbstractRepository<ScannedPath> {

    @Override
    public Class<ScannedPath> getReflection() {
        return ScannedPath.class;
    }

}
