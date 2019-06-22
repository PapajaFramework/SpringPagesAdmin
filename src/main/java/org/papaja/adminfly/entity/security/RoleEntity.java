package org.papaja.adminfly.entity.security;

import org.papaja.adminfly.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "security_roles")
public class RoleEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<UserEntity> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "security_roles_privileges",
        joinColumns = @JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "privilege_id",
            referencedColumnName = "id"
        )
    )
    private Collection<PrivilegeEntity> privileges;

    public RoleEntity() {
        this(null);
    }

    public RoleEntity(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<UserEntity> getUsers() {
        return users;
    }

    public Collection<PrivilegeEntity> getPrivileges() {
        return privileges;
    }

    @Override
    public String toString() {
        return String.format("RoleEntity{id=%d, name='%s', privileges=%s}", id, name, privileges);
    }
}
