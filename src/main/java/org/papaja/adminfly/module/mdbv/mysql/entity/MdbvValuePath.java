package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.module.blog.entity.Domain;
import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
@Table(name = "mdbv_value_paths")
public class MdbvValuePath extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "value_path")
    private String path;

    @Column(name = "value_type", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Type type;

    @OneToOne(cascade = {
        CascadeType.PERSIST, CascadeType.MERGE
    }, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="collection_id")
    private MdbvCollection collection;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public MdbvCollection getCollection() {
        return collection;
    }

    public void setCollection(MdbvCollection collection) {
        this.collection = collection;
    }

    public enum Type {
        RAW, BASE64, LIST, MAP
    }

    @Override
    public String toString() {
        return format("MdbvValuePath{name='%s', path='%s', type='%s'}", name, path, type);
    }
}
