package org.papaja.adminfly.repository;

import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.papaja.adminfly.entity.AbstractEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"all"})
abstract public class AbstractRepository<E extends AbstractEntity> {

    @Autowired
    protected SessionFactory factory;

    public void persist(E entity) {
        session().persist(entity);
    }

    protected Session session() {
        return factory.getCurrentSession();
    }

    public void save(E entity) {
        session().save(entity);
    }

    public void merge(E entity) {
        session().merge(entity);
    }

    public void flush() {
        session().flush();
    }

    public void remove(E entity) {
        session().delete(entity);
    }

    public void remove(Integer id) {
        remove(get(id));
    }

    public E get(Integer id) {
        return session().get(getReflection(), id);
    }

    public void refresh(E entity) {
        session().refresh(entity);
    }

    public CriteriaBuilder criteriaBuilder() {
        return session().getCriteriaBuilder();
    }

    public List<E> getList(CriteriaQuery<E> criteria) {
        return createQuery(criteria).getResultList();
    }

    public Query<E> createQuery(CriteriaQuery<E> criteria) {
        return session().createQuery(criteria);
    }

    public List<E> getList() {
        return createQuery().getResultList();
    }

    public Query<E> createQuery() {
        return session().createQuery(String.format("from %s", getReflection().getSimpleName()));
    }

    public E uniqueResult(CriteriaQuery<E> criteria) {
        return createQuery(criteria).uniqueResult();
    }

    public E uniqueResult() {
        return createQuery().uniqueResult();
    }

    public List<E> getList(Integer... ids) {
        return getList(Arrays.asList(ids));
    }

    public List<E> getList(List<Integer> ids) {
        return getMultiAccessor(getReflection()).multiLoad(ids);
    }

    public MultiIdentifierLoadAccess getMultiAccessor(Class<E> reflection) {
        return session().byMultipleIds(reflection);
    }

    public CriteriaQuery<E> criteriaQueryFor(String column, Object value) {
        CriteriaBuilder  builder = criteriaBuilder();
        CriteriaQuery<E> query   = builder.createQuery(getReflection());
        Root<E>          root    = query.from(getReflection());

        query.select(root);
        query.where(builder.equal(root.get(column), value));

        return query;
    }

    public E getOneFor(String column, String value) {
        return uniqueResult(criteriaQueryFor(column, value));
    }

    public List<E> getListFor(String column, String value) {
        return getList(criteriaQueryFor(column, value));
    }

    abstract public Class<E> getReflection();

}
