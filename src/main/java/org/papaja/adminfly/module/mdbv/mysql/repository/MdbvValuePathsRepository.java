package org.papaja.adminfly.module.mdbv.mysql.repository;

import org.hibernate.query.Query;
import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvCollection;
import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvValuePath;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MdbvValuePathsRepository extends AbstractRepository<MdbvValuePath> {

    public List<MdbvValuePath> getPaths(MdbvCollection collection) {
        return getList(criteriaQuery("collection", collection));
    }

    @Override
    public Class<MdbvValuePath> getReflection() {
        return MdbvValuePath.class;
    }

}
