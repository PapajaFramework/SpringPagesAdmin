package org.papaja.adminfly.repository.blog;

import org.hibernate.SessionFactory;
import org.papaja.adminfly.entity.blog.Post;
import org.papaja.adminfly.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostRepository extends AbstractRepository {

    @Autowired
    private SessionFactory factory;

    public List<Post> getPosts() {
        return session().createQuery("from Post").getResultList();
    }

    public Post getPost(Integer id) {
        return session().get(Post.class, id);
    }

}
