package org.papaja.adminify.service;

import org.papaja.adminify.dao.UserDao;
import org.papaja.adminify.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.security.core.userdetails.User.UserBuilder;
import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User        user    = dao.getUser(username);
        UserBuilder builder = withUsername(user.getName());

        builder.password(user.getPassword());
        builder.authorities("ADMIN");

        return builder.build();
    }

    @Transactional
    public User getProfile(Integer id) {
        return dao.getUser(id);
    }

    @Transactional
    public void persist(User user) {
        dao.persist(user);
    }

}
