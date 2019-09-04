package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.Scanned;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ScannedRepository extends AbstractRepository<Scanned> {

    @Override
    public Class<Scanned> getReflection() {
        return Scanned.class;
    }

}
