package org.papaja.adminfly.mapper.blog;

import org.papaja.adminfly.core.mapping.Mapper;
import org.papaja.adminfly.dto.blog.PostDto;
import org.papaja.adminfly.entity.blog.Post;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class PostMapper implements Mapper<PostDto, Post> {

    @Override
    public void map(PostDto source, Post target) {
        target.setUpdated(Timestamp.from(Instant.now()));
        target.setBody(source.getBody());
        target.setTitle(source.getTitle());
    }

    @Override
    public Post get() {
        return new Post();
    }

}
