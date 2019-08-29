package org.papaja.adminfly.module.blog.repository;

import org.papaja.adminfly.module.blog.entity.Domain;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DomainRepository extends AbstractRepository<Domain> {

    public List<Domain> getDomains() {
        return getList();
    }

    public List<Domain> getDomains(List<Integer> ids) {
        return getList(ids);
    }

    public Domain getDomain(Integer id) {
        return get(id);
    }

    @Override
    public Class<Domain> getReflection() {
        return Domain.class;
    }
}
