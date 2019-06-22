package org.papaja.adminfly.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.papaja.adminfly.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@SuppressWarnings({"all"})
abstract public class AbstractRepository<E extends AbstractEntity> {

    @Autowired
    protected SessionFactory factory;

    protected Session session() {
        return factory.getCurrentSession();
    }

    public void persist(E entity) {
        session().persist(entity);
    }

    public void save(E entity) {
        session().save(entity);
    }

    public void merge(E entity) {
        session().merge(entity);
    }

    public void refresh(E entity) {
        session().refresh(entity);
    }

    public Query<E> createQuery(Class<E> reflection) {
        return session().createQuery(String.format("from %s", reflection.getSimpleName()));
    }

    public Query<E> createQuery(CriteriaQuery<E> criteria) {
        return session().createQuery(criteria);
    }

    public CriteriaBuilder criteriaBuilder() {
        return session().getCriteriaBuilder();
    }

    public List<E> getList(CriteriaQuery<E> criteria) {
        return createQuery(criteria).getResultList();
    }

    public List<E> getList(Class<E> reflection) {
        return createQuery(reflection).getResultList();
    }

    public E uniqueResult(CriteriaQuery<E> criteria) {
        return createQuery(criteria).uniqueResult();
    }

    public E uniqueResult(Class<E> reflection) {
        return createQuery(reflection).uniqueResult();
    }

}
