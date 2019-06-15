package org.papaja.adminify.service;

import org.papaja.adminify.dao.UserDao;
import org.papaja.adminify.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

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
    public List<User> getUsers() {
        return dao.getUsers();
    }

    @Transactional
    public void persist(User user) {
        dao.persist(user);
    }

}
