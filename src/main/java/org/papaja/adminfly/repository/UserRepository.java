package org.papaja.adminfly.repository;

import org.hibernate.query.Query;
import org.papaja.adminfly.core.hibernate.Pagination;
import org.papaja.adminfly.entity.security.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository extends AbstractRepository {

    public User getUser(String name) {
        Query query = session().createQuery("FROM User WHERE username = :username");

        query.setParameter("username", name);

        return (User) query.uniqueResult();
    }

    public List<User> getUsers(int offset, int limit) {
        Query query = session().createQuery("FROM User");

        Pagination<User> pagination = Pagination.of(query, offset, limit);

        return pagination.getResult();
    }

    public User getUser(Integer id) {
        return session().get(User.class, id);
    }

    public void merge(User user) {
        session().refresh(user);
//        session().merge(user);
    }

}
