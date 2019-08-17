package org.papaja.adminfly.shared.repository;

import org.hibernate.query.Query;
import org.papaja.adminfly.shared.entity.User;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository extends AbstractRepository<User> {

    public User getUser(String name) {
        return getOne("username", name);
    }

    public User getUser(Integer id) {
        return get(id);
    }

    public List<User> getUsers() {
        return getList();
    }

    public Query<User> getUsersQuery() {
        return createQuery();
    }

    @Override
    public Class<User> getReflection() {
        return User.class;
    }
}
