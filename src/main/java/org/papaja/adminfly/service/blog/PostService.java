package org.papaja.adminfly.service.blog;

import org.papaja.adminfly.commons.vendor.hibernate.Pagination;
import org.papaja.adminfly.entity.blog.Domain;
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
        String domain = domains.getActiveDomain().getDomain();

        return Pagination.of(repository.getPostsQuery(domain), offset, MAX_RESULT_PER_PAGE);
    }

    public void merge(Post post) {
        repository.merge(post);
    }

}
