package org.papaja.adminfly.entity.blog;

import org.papaja.adminfly.entity.AbstractEntity;
import org.papaja.adminfly.entity.security.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "blog_domains")
public class Domain extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "domain")
    private String domain;

    @ManyToMany(cascade = {
        CascadeType.DETACH, CascadeType.MERGE,
        CascadeType.REFRESH, CascadeType.PERSIST
    })
    @JoinTable(name = "blog_users_domains",
        joinColumns = @JoinColumn(name = "domain_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Collection<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public Set<Integer> getUsersIds() {
        return users.stream().map(User::getId).collect(Collectors.toSet());
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Boolean hasUserAccess(Integer userId) {
        return getUsersIds().contains(userId);
    }

    @Override
    public String toString() {
        return String.format("Domain{name='%s', domain='%s'}", name, domain);
    }
}
