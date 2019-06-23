package org.papaja.adminfly.repository.security;

import org.papaja.adminfly.entity.security.PrivilegeEntity;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrivilegeRepository extends AbstractRepository<PrivilegeEntity> {

    public List<PrivilegeEntity> getPrivileges() {
        return getList(PrivilegeEntity.class);
    }

    public List<PrivilegeEntity> getPrivileges(List<Integer> ids) {
        return getList(PrivilegeEntity.class, ids);
    }

}
