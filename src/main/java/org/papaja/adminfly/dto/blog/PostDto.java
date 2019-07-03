package org.papaja.adminfly.dto.blog;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostDto {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 6, max = 64, message = "{validation.size}")
    private String title;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 128, max = 16777215, message = "{validation.size}")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return String.format("PostDto{title='%s', body='%s'}", title, body);
    }
}
