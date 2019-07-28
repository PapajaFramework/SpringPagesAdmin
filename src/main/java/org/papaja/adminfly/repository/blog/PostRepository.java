package org.papaja.adminfly.repository.blog;

import org.hibernate.query.Query;
import org.papaja.adminfly.entity.blog.Domain;
import org.papaja.adminfly.entity.blog.Post;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostRepository extends AbstractRepository<Post> {

    public Query<Post> getPostsQuery(String domain) {
        return createQuery(criteriaQueryFor("domain", domain));
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
