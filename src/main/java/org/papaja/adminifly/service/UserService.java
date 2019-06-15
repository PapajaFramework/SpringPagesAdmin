package org.papaja.adminifly.service;

import org.papaja.adminifly.dao.UserDao;
import org.papaja.adminifly.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private static final int MAX_RESULT_PER_PAGE = 5;

    @Autowired
    private UserDao dao;

    @Transactional
    public User loadUserByUsername(String username) {
        return dao.getUser(username);
    }

    @Transactional
    public User getProfile(Integer id) {
        return dao.getUser(id);
    }

    @Transactional
    public List<User> getUsers(int offset) {
        return dao.getUsers(offset, MAX_RESULT_PER_PAGE);
    }

    @Transactional
    public void persist(User user) {
        dao.persist(user);
    }

}
