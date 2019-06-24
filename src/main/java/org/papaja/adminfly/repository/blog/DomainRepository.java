package org.papaja.adminfly.repository.blog;

import org.papaja.adminfly.entity.blog.Domain;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DomainRepository extends AbstractRepository<Domain> {

    public List<Domain> getDomains() {
        return getList(Domain.class);
    }

    public List<Domain> getDomains(List<Integer> ids) {
        return getList(Domain.class, ids);
    }

    public Domain getDomain(Integer id) {
        return session().get(Domain.class, id);
    }

}
