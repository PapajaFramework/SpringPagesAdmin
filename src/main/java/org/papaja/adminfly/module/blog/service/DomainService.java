package org.papaja.adminfly.module.blog.service;

import org.papaja.adminfly.module.blog.config.properties.BlogProperties;
import org.papaja.adminfly.module.blog.entity.Domain;
import org.papaja.adminfly.shared.entity.User;
import org.papaja.adminfly.module.blog.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class DomainService {

    @Autowired
    private DomainRepository repository;

    @Autowired
    private BlogProperties properties;

    @Autowired
    private HttpSession session;

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

    public List<String> getDomainsNames(List<Domain> domains) {
        return domains.stream().map(Domain::getDomain).collect(Collectors.toList());
    }

    public void removeAccessForUser(User user) {
        for (Domain domain : getDomains()) {
            domain.getUsers().removeIf(u -> u.getId().equals(user.getId()));
            merge(domain);
        }
    }

    public void assignAccessForUser(User user, List<Domain> domains) {
        domains.forEach(domain -> {
            domain.getUsers().add(user);
            merge(domain);
        });
    }

    public void remove(Integer id) {
        repository.remove(id);
    }

    public void remove(Domain entity) {
        repository.remove(entity);
    }

    public void merge(Domain domain) {
        repository.merge(domain);
    }

    public Domain getDomain(Integer id) {
        boolean isValid = (nonNull(id) && id > 0);

        return isValid ? repository.get(id) : new Domain();
    }

    public void setActiveDomain(Integer id) {
        setActiveDomain(getDomain(id));
    }

    public void setActiveDomain(Domain domain) {
        session.setAttribute(properties.getSessionName(), domain.getId());
    }

    public boolean hasActiveDomain() {
        return getActiveDomain().isOld();
    }

    public Domain getActiveDomain() {
        return getDomain((Integer) session.getAttribute(properties.getSessionName()));
    }

}
