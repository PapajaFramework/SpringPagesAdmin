package org.papaja.adminfly.shared.mapper;

import org.papaja.commons.util.Mapper;
import org.papaja.adminfly.shared.dto.RoleDto;
import org.papaja.adminfly.shared.entity.Role;
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
