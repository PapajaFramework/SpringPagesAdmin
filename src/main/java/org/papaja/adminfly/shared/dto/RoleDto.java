package org.papaja.adminfly.shared.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class RoleDto {

    private Integer id;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 4, max = 16, message = "{validation.size}")
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
