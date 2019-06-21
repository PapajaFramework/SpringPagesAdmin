package org.papaja.adminfly.service;

import org.papaja.adminfly.repository.UserRepository;
import org.papaja.adminfly.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class UserService {

    private static final int MAX_RESULT_PER_PAGE = 5;

    @Autowired
    private UserRepository repository;

    @Transactional
    public User loadUserByUsername(String username) {
        return repository.getUser(username);
    }

    @Transactional
    public User getProfile(Integer id) {
        return repository.getUser(id);
    }

    @Transactional
    public List<User> getUsers(int offset) {
        return repository.getUsers(offset, MAX_RESULT_PER_PAGE);
    }

    @Transactional
    public void persist(User user) {
        user.setUpdated(Timestamp.from(Instant.now()));

        repository.merge(user);
    }

}
