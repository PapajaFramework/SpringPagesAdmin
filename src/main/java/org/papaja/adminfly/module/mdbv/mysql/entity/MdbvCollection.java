package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mdbv_collections")
public class MdbvCollection extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "collection")
    private String collection;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

}
