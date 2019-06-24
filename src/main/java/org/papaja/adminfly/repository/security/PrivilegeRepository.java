package org.papaja.adminfly.repository.security;

import org.papaja.adminfly.entity.security.Privilege;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrivilegeRepository extends AbstractRepository<Privilege> {

    public List<Privilege> getPrivileges() {
        return getList(Privilege.class);
    }

    public List<Privilege> getPrivileges(List<Integer> ids) {
        return getList(Privilege.class, ids);
    }

}
