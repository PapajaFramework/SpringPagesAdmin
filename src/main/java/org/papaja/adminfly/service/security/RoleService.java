package org.papaja.adminfly.service.security;

import org.papaja.adminfly.dto.security.RoleDto;
import org.papaja.adminfly.entity.security.Role;
import org.papaja.adminfly.mapper.RoleMapper;
import org.papaja.adminfly.repository.security.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private PrivilegeService privileges;

    @Autowired
    private RoleMapper mapper;

    public List<Role> getRoles() {
        return repository.getRoles();
    }

    public List<Role> getRoles(Integer... ids) {
        return getRoles(Arrays.asList(ids));
    }

    public List<Role> getRoles(List<Integer> ids) {
        ids.removeIf(Objects::isNull);

        return repository.getRoles(ids);
    }

    public void store(RoleDto dto, Role entity) {
        boolean isOld = entity.isOld();
        mapper.map(dto, entity);

        if (isOld) {
            entity.setPrivileges(privileges.getPrivileges(dto.getPrivileges()));
        }

        repository.merge(entity);
    }

    public void remove(Integer id) {
        repository.remove(Role.class, id);
    }

    public void remove(Role entity) {
        repository.remove(entity);
    }

    public Role getRole(Integer id) {
        boolean isValid = (nonNull(id) && id > 0);

        return isValid ? repository.getRole(id) : new Role();
    }

}
