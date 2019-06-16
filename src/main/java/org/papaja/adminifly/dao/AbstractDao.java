package org.papaja.adminifly.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract public class AbstractDao {

    @Autowired
    private SessionFactory factory;

    protected Session getSession() {
        return factory.openSession();
    }

}
