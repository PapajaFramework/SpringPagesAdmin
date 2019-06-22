package org.papaja.adminfly.service.security;

import org.papaja.adminfly.repository.security.RoleRepository;
import org.papaja.adminfly.entity.security.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository repository;

    public List<RoleEntity> getRoles() {
        return repository.getRoles();
    }

}