package org.papaja.adminfly.service.blog;

import org.papaja.adminfly.entity.blog.Post;
import org.papaja.adminfly.repository.blog.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post getPost(Integer id) {
        boolean isValid = (nonNull(id) && id > 0);

        return isValid ? repository.get(id) : new Post();
    }

    public List<Post> getPosts() {
        return repository.getList();
    }

}
