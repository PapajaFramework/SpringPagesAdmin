package org.papaja.adminfly.service;

import org.papaja.adminfly.repository.RoleRepository;
import org.papaja.adminfly.entity.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repository;

    @Transactional
    public List<Role> getRoles() {
        return repository.getRoles();
    }

}
