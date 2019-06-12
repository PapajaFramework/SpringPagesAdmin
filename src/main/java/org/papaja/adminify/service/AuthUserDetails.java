package org.papaja.adminify.service;

import org.papaja.adminify.entity.AuthUser;
import org.papaja.adminify.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetails implements UserDetailsService {

    @Autowired
    private UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.loadUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new AuthUser(user);
    }

}
