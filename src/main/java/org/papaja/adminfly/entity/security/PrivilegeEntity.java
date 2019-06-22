package org.papaja.adminfly.entity.security;

import org.papaja.adminfly.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "security_privileges")
public class PrivilegeEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<RoleEntity> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<RoleEntity> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return String.format("PrivilegeEntity{id=%d, name='%s'}", id, name);
    }
}
