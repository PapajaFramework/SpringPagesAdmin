package org.papaja.adminfly.service.security;

import org.papaja.adminfly.repository.security.UserRepository;
import org.papaja.adminfly.entity.security.User;
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

    public User loadUserByUsername(String username) {
        return repository.getUser(username);
    }

    public User getProfile(Integer id) {
        return repository.getUser(id);
    }

    public List<User> getUsers(int offset) {
        return repository.getUsers(offset, MAX_RESULT_PER_PAGE);
    }

    public void persist(User user) {
        user.setUpdated(Timestamp.from(Instant.now()));

        repository.merge(user);
    }

}
