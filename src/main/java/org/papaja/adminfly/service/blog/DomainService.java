package org.papaja.adminfly.service.blog;

import org.papaja.adminfly.entity.blog.Domain;
import org.papaja.adminfly.repository.blog.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class DomainService {

    @Autowired
    private DomainRepository repository;

    public List<Domain> getDomains() {
        return repository.getDomains();
    }

    public List<Domain> getDomains(Integer... ids) {
        return getDomains(Arrays.asList(ids));
    }

    public List<Domain> getDomains(List<Integer> ids) {
        ids.removeIf(Objects::isNull);

        return repository.getDomains(ids);
    }

    public void remove(Integer id) {
        repository.remove(id);
    }

    public void remove(Domain entity) {
        repository.remove(entity);
    }

    public Domain getDomain(Integer id) {
        boolean isValid = (nonNull(id) && id > 0);

        return isValid ? repository.get(id) : new Domain();
    }

}
