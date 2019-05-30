package org.papaja.adminify.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.papaja.adminify.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@SuppressWarnings("all")
public class ProfileDao {

    @Autowired
    private SessionFactory factory;

    public Profile getProfile(Integer id) {
        return getSession().get(Profile.class, id);
    }

    public void persist(Profile profile) {
        getSession().saveOrUpdate(profile);
    }

    public List<Profile> getProfiles() {
        TypedQuery<Profile> query = getSession().createQuery("from Profile");

        query.setMaxResults(100);

        return query.getResultList();
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

}
