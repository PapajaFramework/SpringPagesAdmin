package org.papaja.adminifly.dao;

import org.hibernate.query.Query;
import org.papaja.adminifly.core.hibernate.Pagination;
import org.papaja.adminifly.entity.security.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao extends AbstractDao {

    public User getUser(String name) {
        Query query = getSession().createQuery("FROM User WHERE username = :username");

        query.setParameter("username", name);

        return (User) query.uniqueResult();
    }

    public List<User> getUsers(int offset, int limit) {
        Query query = getSession().createQuery("FROM User");

        Pagination<User> pagination = Pagination.of(query, offset, limit);

        return pagination.getResult();
    }

    public User getUser(Integer id) {
        return getSession().get(User.class, id);
    }

    public User getUserDetails(Integer id) {
        return getSession().get(User.class, id);
    }

    public void persist(User user) {
        getSession().saveOrUpdate(user);
    }

}
