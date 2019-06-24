package org.papaja.adminfly.repository.security;

import org.papaja.adminfly.entity.security.Role;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository extends AbstractRepository<Role> {

    public List<Role> getRoles() {
        return getList(Role.class);
    }

    public List<Role> getRoles(List<Integer> ids) {
        return getList(Role.class, ids);
    }

    public Role getRole(Integer id) {
        return session().get(Role.class, id);
    }

}
