package org.papaja.adminfly.entity.security;

import org.papaja.adminfly.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "security_roles")
public class Role extends AbstractEntity {

    @NotEmpty(message = "role.empty")
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {
        CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(
        name = "security_users_roles",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Collection<User> users;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
        CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(
        name = "security_roles_privileges",
        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id")
    )
    private Collection<Privilege> privileges;

    public Role() {
        this(null);
    }

    public Role(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public List<Integer> getPrivilegesIds() {
        return privileges.stream().map(Privilege::getId).collect(Collectors.toList());
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String toString() {
        return String.format("Role{id=%d, name='%s', privileges=%s}", id, name, privileges);
    }
}
