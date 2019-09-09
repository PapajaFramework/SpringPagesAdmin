package org.papaja.adminfly.module.mdbv.mysql.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static java.lang.String.format;

public class RowDto {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 2, max = 64, message = "{validation.size}")
    private String name;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 2, max = 64, message = "{validation.size}")
    private String path;

    @Size(min = 3, max = 12, message = "{validation.size}")
    private String type;

    @NotNull(message = "{validation.notNull}")
    private Integer position;

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return format("SourcePathDto{name='%s', path='%s', type=%s}", name, path, type);
    }
}
