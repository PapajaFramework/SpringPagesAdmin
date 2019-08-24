package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.papaja.adminfly.module.mdbv.mysql.entity.SourcePath;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SourcePathRepository extends AbstractRepository<SourcePath> {

    @Override
    public Class<SourcePath> getReflection() {
        return SourcePath.class;
    }

}
