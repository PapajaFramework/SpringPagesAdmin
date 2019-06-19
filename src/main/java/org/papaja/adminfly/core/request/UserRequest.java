package org.papaja.adminfly.core.request;

import java.util.ArrayList;
import java.util.List;

public class UserRequest {

    private String username;
    private List<String> roles;

    public UserRequest() {
        roles = new ArrayList<>();
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role) {
        roles.add(role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("UserRequest{username='%s', roles=%s}", username, roles);
    }
}
