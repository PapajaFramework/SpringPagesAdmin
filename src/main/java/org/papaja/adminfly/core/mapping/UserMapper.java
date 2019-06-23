package org.papaja.adminfly.core.mapping;

import org.papaja.adminfly.dto.security.UserDto;
import org.papaja.adminfly.entity.security.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class UserMapper implements Mapper<UserDto, UserEntity> {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void map(UserDto source, UserEntity target) {
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
    public UserEntity get() {
        return new UserEntity();
    }

}
