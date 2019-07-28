package org.papaja.adminfly.repository.blog;

import org.papaja.adminfly.entity.blog.Domain;
import org.papaja.adminfly.entity.blog.UserAccessDomain;
import org.papaja.adminfly.entity.security.User;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class UserAccessDomainRepository extends AbstractRepository<UserAccessDomain> {

    public Set<User> getUsers(Domain domain) {
        return null;
    }

    @Override
    public Class<UserAccessDomain> getReflection() {
        return UserAccessDomain.class;
    }

}
