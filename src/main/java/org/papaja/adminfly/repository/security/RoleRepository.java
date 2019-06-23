package org.papaja.adminfly.repository.security;

import org.papaja.adminfly.entity.security.RoleEntity;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class RoleRepository extends AbstractRepository<RoleEntity> {

    public List<RoleEntity> getRoles() {
        return getList(RoleEntity.class);
    }

    public List<RoleEntity> getRoles(List<Integer> ids) {
        return getList(RoleEntity.class, ids);
    }

}
