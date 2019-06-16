package org.papaja.adminfly.core.request;

public class UserRequest {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return String.format("UserRequest{username='%s'}", username);
    }
}
