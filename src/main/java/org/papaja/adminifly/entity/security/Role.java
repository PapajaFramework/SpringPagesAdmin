package org.papaja.adminifly.entity.security;

import javax.persistence.*;
import java.util.Collection;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_privileges",
        joinColumns = @JoinColumn(
            name = "role_id",
            referencedColumnName = "id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "privilege_id",
            referencedColumnName = "id"
        )
    )
    private Collection<Privilege> privileges;

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

    public Collection<User> getUsers() {
        return users;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    @Override
    public String toString() {
        return String.format("Role{id=%d, name='%s', privileges=%s}", id, name, privileges);
    }
}
