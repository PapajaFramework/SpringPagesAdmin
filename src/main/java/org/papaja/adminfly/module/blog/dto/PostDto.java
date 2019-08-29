package org.papaja.adminfly.module.blog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostDto {

    private Integer id;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 6, max = 64, message = "{validation.size}")
    private String title;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 16, max = 16777215, message = "{validation.size}")
    private String body;

    @NotNull(message = "{validation.notNull}")
    private Integer category;

    private boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getCategoryId() {
        return category;
    }

    public void setCategoryId(Integer category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("PostDto{title='%s', body='%s', category=%d, enabled=%s}",
            title, body, category, enabled);
    }
}
