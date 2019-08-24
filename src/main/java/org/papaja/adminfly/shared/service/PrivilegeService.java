package org.papaja.adminfly.shared.service;

import org.papaja.adminfly.shared.entity.Privilege;
import org.papaja.adminfly.shared.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PrivilegeService extends AbstractService<Privilege, PrivilegeRepository> {

    @Autowired
    private PrivilegeRepository repository;

    public List<Privilege> getPrivileges() {
        return getAll();
    }

    public List<Privilege> getPrivileges(List<Integer> ids) {
        return getAll(ids);
    }

    @Override
    public PrivilegeRepository getRepository() {
        return repository;
    }

    @Override
    public Privilege get() {
        return new Privilege();
    }

}
