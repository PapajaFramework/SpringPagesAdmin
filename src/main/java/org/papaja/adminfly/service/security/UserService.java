package org.papaja.adminfly.service.security;

import org.papaja.adminfly.core.hibernate.Pagination;
import org.papaja.adminfly.core.mapping.UserMapper;
import org.papaja.adminfly.dto.security.UserDto;
import org.papaja.adminfly.entity.security.UserEntity;
import org.papaja.adminfly.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class UserService {

    private static final int MAX_RESULT_PER_PAGE = 5;

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleService roles;

    @Autowired
    private UserMapper mapper;

    public UserEntity loadUserByUsername(String username) {
        return repository.getUser(username);
    }

    public Pagination<UserEntity> getUsers(int offset) {
        return Pagination.of(repository.getUsersQuery(), offset, MAX_RESULT_PER_PAGE);
    }

    public void store(UserDto dto, UserEntity entity) {
        mapper.map(dto, entity);

        if (entity.isOld()) {
            entity.setRoles(roles.getRoles(dto.getRoles()));
        }

        store(entity);
    }

    public void store(UserEntity user) {
        repository.merge(user);
    }

    public UserEntity getUser(Integer id) {
        boolean isValid = (nonNull(id) && id > 0);

        return isValid ? repository.getUser(id) : new UserEntity();
    }

    public UserEntity getUser(Long id) {
        return getUser(id.intValue());
    }

}
