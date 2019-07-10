package org.papaja.adminfly.service.security;

import org.papaja.adminfly.entity.security.Privilege;
import org.papaja.adminfly.repository.security.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository repository;

    public List<Privilege> getPrivileges() {
        return repository.getPrivileges();
    }

    public List<Privilege> getPrivileges(List<Integer> ids) {
        ids.removeIf(Objects::isNull);

        return repository.getPrivileges(ids);
    }

    public void merge(Privilege entity) {
        repository.merge(entity);
    }

    public void remove(Integer id) {
        repository.remove(id);
    }

    public void remove(Privilege privilege) {
        repository.remove(privilege);
    }

}
