package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "mdbv_collections")
public class MdbvCollection extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "collection")
    private String collection;

    @OneToMany(mappedBy = "collection")
    private Collection<MdbvValuePath> paths;

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

    public Collection<MdbvValuePath> getPaths() {
        return paths;
    }

    public void setPaths(Collection<MdbvValuePath> paths) {
        this.paths = paths;
    }

}
