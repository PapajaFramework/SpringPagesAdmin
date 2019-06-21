package org.papaja.adminfly.repository;

import org.papaja.adminfly.entity.security.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepository extends AbstractRepository {

    public List<Role> getRoles() {
        return session().createQuery("from Role").getResultList();
    }

}
