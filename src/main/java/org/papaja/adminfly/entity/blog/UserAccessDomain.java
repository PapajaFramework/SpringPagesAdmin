package org.papaja.adminfly.entity.blog;

import org.papaja.adminfly.entity.AbstractEntity;
import org.papaja.adminfly.entity.security.User;

import javax.persistence.*;
import java.util.Set;

//@Entity
//@Table(name = "blog_users_domains")
public class UserAccessDomain extends AbstractEntity {

    @OneToMany(mappedBy="user")
    private Set<User> users;

    @OneToMany(mappedBy="domain")
    private Set<Domain> domains;

    public Set<User> getUsers() {
        return users;
    }

    public Set<Domain> getDomains() {
        return domains;
    }

}
