package org.papaja.adminfly.shared.repository;

import org.papaja.adminfly.shared.entity.Privilege;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrivilegeRepository extends AbstractRepository<Privilege> {

    public List<Privilege> getPrivileges() {
        return getList();
    }

    public List<Privilege> getPrivileges(List<Integer> ids) {
        return getList(ids);
    }

    @Override
    public Class<Privilege> getReflection() {
        return Privilege.class;
    }
}
