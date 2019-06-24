package org.papaja.adminfly.service.security;

import org.papaja.adminfly.entity.security.PrivilegeEntity;
import org.papaja.adminfly.repository.security.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository repository;

    public List<PrivilegeEntity> getPrivileges() {
        return repository.getPrivileges();
    }

    public List<PrivilegeEntity> getPrivileges(List<Integer> ids) {
        return repository.getPrivileges(ids);
    }

    public void store(PrivilegeEntity entity) {
        repository.merge(entity);
    }

}
