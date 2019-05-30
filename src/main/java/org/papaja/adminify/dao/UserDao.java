package org.papaja.adminify.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.papaja.adminify.entity.User;
import org.papaja.adminify.entity.UserDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory factory;

    public UserDetailsEntity getUser(String name) {
        Query query = getSession().createQuery("from UserDetailsEntity where username = :username");

        query.setParameter("username", name);

        return (UserDetailsEntity) query.getResultList().get(0);
    }

    public User getUser(Integer id) {
        return getSession().get(User.class, id);
    }

    public UserDetailsEntity getUserDetails(Integer id) {
        return getSession().get(UserDetailsEntity.class, id);
    }

    public void persist(User user) {
        getSession().saveOrUpdate(user);
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

}
