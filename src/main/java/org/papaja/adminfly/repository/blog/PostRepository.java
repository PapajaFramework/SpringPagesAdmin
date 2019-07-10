package org.papaja.adminfly.repository.blog;

import org.hibernate.query.Query;
import org.papaja.adminfly.entity.blog.Domain;
import org.papaja.adminfly.entity.blog.Post;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class PostRepository extends AbstractRepository<Post> {

    public Query<Post> getPostsQuery(Domain domain) {
        CriteriaBuilder     builder = criteriaBuilder();
        CriteriaQuery<Post> query   = builder.createQuery(getReflection());
        Root<Post>          root    = query.from(getReflection());

        query.select(root);
        query.where(builder.equal(root.get("domain"), domain));

        return createQuery(query);
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
