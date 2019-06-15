package org.papaja.adminify.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.papaja.adminify.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory factory;

    public User getUser(String name) {
        Query query = getSession().createQuery("from User where username = :username");

        query.setParameter("username", name);

        return (User) query.uniqueResult();
    }

    public List<User> getUsers() {
        return getSession().createQuery("from User").getResultList();
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

    private Session getSession() {
        return factory.getCurrentSession();
    }

}
