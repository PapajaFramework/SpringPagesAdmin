package org.papaja.adminfly.mapper.security;

import org.papaja.adminfly.core.mapping.Mapper;
import org.papaja.adminfly.dto.security.RoleDto;
import org.papaja.adminfly.entity.security.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper implements Mapper<RoleDto, Role> {

    @Override
    public void map(RoleDto source, Role target) {
        target.setName(source.getName().toUpperCase());
    }

    @Override
    public Role get() {
        return new Role();
    }

}
