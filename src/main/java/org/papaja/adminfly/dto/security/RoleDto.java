package org.papaja.adminfly.dto.security;

import java.util.List;

public class RoleDto {

    private Integer id;

    private String name;

    private List<Integer> privileges;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Integer> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return String.format("RoleDto{id=%d, name='%s', privileges=%s}", id, name, privileges);
    }
}
