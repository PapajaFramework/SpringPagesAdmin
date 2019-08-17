package org.papaja.adminfly.shared.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "security_privileges")
public class Privilege extends AbstractEntity {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 3, max = 64, message = "{validation.size}")
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(name = "security_roles_privileges",
        joinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return String.format("Privilege{id=%d, name='%s'}", id, name);
    }
}
