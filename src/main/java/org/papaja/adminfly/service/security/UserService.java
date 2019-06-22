package org.papaja.adminfly.service.security;

import org.papaja.adminfly.core.hibernate.Pagination;
import org.papaja.adminfly.repository.security.UserRepository;
import org.papaja.adminfly.entity.security.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class UserService {

    private static final int MAX_RESULT_PER_PAGE = 5;

    @Autowired
    private UserRepository repository;

    public UserEntity loadUserByUsername(String username) {
        return repository.getUser(username);
    }

    public UserEntity getProfile(Integer id) {
        return repository.getUser(id);
    }

    public List<UserEntity> getUsers(int offset) {
        Pagination<UserEntity> pagination = Pagination.of(repository.getUsersQuery(), offset, MAX_RESULT_PER_PAGE);

        return pagination.getResult();
    }

    public void store(UserEntity user) {
        user.setUpdated(Timestamp.from(Instant.now()));

        repository.merge(user);
    }

}
