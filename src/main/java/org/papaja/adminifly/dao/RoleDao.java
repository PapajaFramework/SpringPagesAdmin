package org.papaja.adminifly.dao;

import org.papaja.adminifly.entity.security.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDao extends AbstractDao {

    public List<Role> getRoles() {
        return getSession().createQuery("from Role").getResultList();
    }

}
