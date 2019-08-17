package org.papaja.adminfly.module.blog.repository;

import org.hibernate.query.Query;
import org.papaja.adminfly.module.blog.entity.Domain;
import org.papaja.adminfly.module.blog.entity.Post;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostRepository extends AbstractRepository<Post> {

    public Query<Post> getPostsQuery(Domain domain) {
        return createQuery(criteriaQuery("domain", domain));
    }

    public List<Post> getPosts() {
        return getList();
    }

    public Post getPost(Integer id) {
        return get(id);
    }

    @Override
    public Class<Post> getReflection() {
        return Post.class;
    }
}
