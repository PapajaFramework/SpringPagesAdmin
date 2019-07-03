package org.papaja.adminfly.dto.blog;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

    @NotBlank(message = "{validation.notBlank}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("CategoryDto{name='%s'}", name);
    }
}
