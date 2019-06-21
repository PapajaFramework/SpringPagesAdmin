package org.papaja.adminfly.repository.blog;

import org.hibernate.SessionFactory;
import org.papaja.adminfly.entity.blog.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostRepository {

    @Autowired
    private SessionFactory factory;

    public List<Post> getPosts() {
        return factory.getCurrentSession().createQuery("from Post").getResultList();
    }

    public Post getPost(Integer id) {
        return factory.getCurrentSession().get(Post.class, id);
    }

}
