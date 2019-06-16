package org.papaja.adminfly.entity.security;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "privileges")
public class Privilege extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "privileges")
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
