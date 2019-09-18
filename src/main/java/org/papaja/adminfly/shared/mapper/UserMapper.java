package org.papaja.adminfly.shared.mapper;

import org.papaja.commons.util.Mapper;
import org.papaja.adminfly.shared.dto.UserDto;
import org.papaja.adminfly.shared.entity.User;
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
