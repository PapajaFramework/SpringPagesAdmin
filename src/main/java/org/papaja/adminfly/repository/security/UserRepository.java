package org.papaja.adminfly.repository.security;

import org.hibernate.query.Query;
import org.papaja.adminfly.entity.security.UserEntity;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepository extends AbstractRepository<UserEntity> {

    public UserEntity getUser(String name) {
        CriteriaBuilder           builder = criteriaBuilder();
        CriteriaQuery<UserEntity> query   = builder.createQuery(UserEntity.class);
        Root<UserEntity>          root    = query.from(UserEntity.class);

        query.select(root);
        query.where(builder.equal(root.get("username"), name));

        return uniqueResult(query);
    }

    public UserEntity getUser(Integer id) {
        return session().get(UserEntity.class, id);
    }

    public List<UserEntity> getUsers() {
        return getList(UserEntity.class);
    }

    public Query<UserEntity> getUsersQuery() {
        return createQuery(UserEntity.class);
    }

}
