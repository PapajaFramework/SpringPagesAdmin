package org.papaja.adminfly.service;

import org.papaja.adminfly.dao.RoleDao;
import org.papaja.adminfly.entity.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleDao dao;

    public List<Role> getRoles() {
        return dao.getRoles();
    }

}
