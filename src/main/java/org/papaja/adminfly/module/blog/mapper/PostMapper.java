package org.papaja.adminfly.module.blog.mapper;

import org.papaja.adminfly.module.blog.dto.PostDto;
import org.papaja.adminfly.module.blog.entity.Post;
import org.papaja.commons.util.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
public class PostMapper implements Mapper<PostDto, Post> {

    @Override
    public void map(PostDto source, Post target) {
        Timestamp timestamp = Timestamp.from(Instant.now());

        if (target.isNew()) {
            target.setCreated(timestamp);
            target.setViews(0);
        }

        target.setUpdated(timestamp);
        target.setBody(source.getBody());
        target.setTitle(source.getTitle());
        target.setEnabled(source.isEnabled());
    }

    @Override
    public Post get() {
        return new Post();
    }

}
