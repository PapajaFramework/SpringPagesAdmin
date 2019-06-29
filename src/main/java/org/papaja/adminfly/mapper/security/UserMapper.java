package org.papaja.adminfly.mapper.security;

import org.papaja.adminfly.core.mapping.Mapper;
import org.papaja.adminfly.dto.security.UserDto;
import org.papaja.adminfly.entity.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class UserMapper implements Mapper<UserDto, User> {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void map(UserDto source, User target) {
        if (target.isNew()) {
            target.setCreated(Timestamp.from(Instant.now()));
        }

        target.setUsername(source.getUsername());
        target.setEnabled(source.isEnabled());

        if (!source.getPassword().isEmpty()) {
            target.setPassword(encoder.encode(source.getPassword()));
        }

        if (target.isOld()) {
            target.setUpdated(Timestamp.from(Instant.now()));
        }
    }

    @Override
    public User get() {
        return new User();
    }

}
