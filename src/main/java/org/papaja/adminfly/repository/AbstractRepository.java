package org.papaja.adminfly.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

abstract public class AbstractRepository {

    @Autowired
    private SessionFactory factory;

    protected Session session() {
        return factory.getCurrentSession();
    }

}
