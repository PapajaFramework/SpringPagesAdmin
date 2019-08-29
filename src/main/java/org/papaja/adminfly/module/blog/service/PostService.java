package org.papaja.adminfly.module.blog.service;

import org.papaja.adminfly.shared.vendor.hibernate.Pagination;
import org.papaja.adminfly.module.blog.entity.Post;
import org.papaja.adminfly.module.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class PostService {

    private static final int MAX_RESULT_PER_PAGE = 10;

    @Autowired
    private DomainService domains;

    @Autowired
    private PostRepository repository;

    public Post getPost(Integer id) {
        boolean isValid = (nonNull(id) && id > 0);

        return isValid ? repository.get(id) : new Post();
    }

    public List<Post> getPosts() {
        return repository.getList();
    }

    public Pagination<Post> getPosts(int offset) {
        return Pagination.of(repository.getPostsQuery(domains.getActiveDomain()), offset, MAX_RESULT_PER_PAGE);
    }

    public void merge(Post post) {
        repository.merge(post);
    }

}
