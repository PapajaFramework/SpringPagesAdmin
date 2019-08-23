package org.papaja.adminfly.shared.service;

import org.papaja.adminfly.common.util.function.Supplier;
import org.papaja.adminfly.shared.entity.AbstractEntity;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;

@Transactional
abstract public class AbstractService<E extends AbstractEntity, R extends AbstractRepository<E>> implements Supplier<E> {

    public void remove(Integer id) {
        remove(getOne(id));
    }

    public void remove(E entity) {
        getRepository().remove(entity);
    }

    public void merge(E entity) {
        getRepository().merge(entity);
    }

    public E getOne() {
        return getOne(null);
    }

    public E getOne(Integer id) {
        return nonNull(id) ? getRepository().get(id) : get();
    }

    public List<E> getAll() {
        return getRepository().getList();
    }

    public <T extends Serializable> List<E> getAll(T... ids) {
        return getAll(asList(ids));
    }

    public <T extends Serializable> List<E> getAll(List<T> ids) {
        return getRepository().getList(cleanIds(ids));
    }

    public <S extends E> List<E> getAll(String column, S entity) {
        return getRepository().getList(column, entity);
    }

    public <T extends Serializable> List<T> cleanIds(List<T> ids) {
        return cleanIds(ids);
    }

    public <T extends Serializable> List<T> cleanIds(List<T> ids, Predicate<T> predicate) {
        ids.removeIf(predicate);

        return ids;
    }

    abstract public R getRepository();

}
