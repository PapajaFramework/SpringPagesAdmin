package org.papaja.adminfly.shared.service;

import org.papaja.adminfly.shared.dto.RoleDto;
import org.papaja.adminfly.shared.entity.Role;
import org.papaja.adminfly.shared.mapper.RoleMapper;
import org.papaja.adminfly.shared.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class RoleService extends AbstractService<Role, RoleRepository> {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PrivilegeService privileges;

    @Autowired
    private RoleMapper mapper;

    public List<Role> getRoles() {
        return getAll();
    }

    public List<Role> getRoles(List<Integer> ids) {
        return getAll(ids);
    }

    public void store(RoleDto dto, Role entity) {
        mapper.map(dto, entity);

        if (entity.isOld()) {
            entity.setPrivileges(privileges.getPrivileges(dto.getPrivileges()));
        }

        repository.merge(entity);
    }

    public Role getRole(Integer id) {
        return getOne(id);
    }

    @Override
    public RoleRepository getRepository() {
        return repository;
    }

    @Override
    public Role get() {
        return new Role();
    }

}
