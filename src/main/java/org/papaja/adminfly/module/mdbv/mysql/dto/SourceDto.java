package org.papaja.adminfly.module.mdbv.mysql.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static java.lang.String.format;

public class SourceDto {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 4, max = 32, message = "{validation.size}")
    private String name;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 4, max = 16, message = "{validation.size}")
    private String database;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 4, max = 32, message = "{validation.size}")
    private String collection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return format("SourceDto{name='%s', collection='%s'}", name, collection);
    }

}
