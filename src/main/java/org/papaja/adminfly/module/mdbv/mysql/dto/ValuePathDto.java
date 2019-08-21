package org.papaja.adminfly.module.mdbv.mysql.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static java.lang.String.format;

public class ValuePathDto {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 4, max = 64, message = "{validation.size}")
    private String name;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 4, max = 64, message = "{validation.size}")
    private String path;

    @Size(min = 3, max = 8, message = "{validation.size}")
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return format("ValuePathDto{name='%s', path='%s', type=%s}", name, path, type);
    }
}
