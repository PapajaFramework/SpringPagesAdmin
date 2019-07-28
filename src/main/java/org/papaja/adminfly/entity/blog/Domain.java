package org.papaja.adminfly.entity.blog;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.papaja.adminfly.entity.AbstractEntity;
import org.papaja.adminfly.entity.security.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "blog_domains")
public class Domain extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "domain")
    private String domain;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "blog_users_domains",
        joinColumns = { @JoinColumn(name = "domain_id", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
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

    @Override
    public String toString() {
        return String.format("Domain{name='%s', domain='%s'}", name, domain);
    }
}
