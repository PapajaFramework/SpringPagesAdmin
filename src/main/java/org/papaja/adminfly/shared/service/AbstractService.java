package org.papaja.adminfly.shared.service;

import org.papaja.adminfly.common.util.function.Supplier;
import org.papaja.adminfly.shared.entity.AbstractEntity;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Transactional
abstract public class AbstractService<E extends AbstractEntity, R extends AbstractRepository<E>> implements Supplier<E> {

    public E getOne(Integer id) {
        return nonNull(id) ? getRepository().get(id) : get();
    }

    public List<E> getAll() {
        return getRepository().getList();
    }

    abstract public R getRepository();

}
