package org.papaja.adminfly.dto.security;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDto {

    private Integer id;

    private String username;

    private String password;

    private List<Integer> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("UserDto{id = %s, username='%s', password='%s', roles=%s}",
            id, username, password, roles);
    }
}
