package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "mdbv_sources")
public class Source extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "db")
    private String database;

    @Column(name = "collection")
    private String collection;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "source")
    private Collection<Row> rows;

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

    public Collection<Row> getRows() {
        return rows;
    }

    public void setRows(Collection<Row> rows) {
        this.rows = rows;
    }

}
