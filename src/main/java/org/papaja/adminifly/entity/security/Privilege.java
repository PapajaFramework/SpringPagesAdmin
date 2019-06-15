package org.papaja.adminifly.entity.security;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "privileges")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

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

    public Collection<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return String.format("Privilege{id=%d, name='%s'}", id, name);
    }
}
