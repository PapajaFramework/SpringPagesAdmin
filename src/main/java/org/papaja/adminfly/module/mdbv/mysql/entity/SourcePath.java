package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
@Table(name = "mdbv_paths")
public class SourcePath extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "value_path")
    private String path;

    @Column(name = "value_type", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="source_id")
    private Source source;

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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public enum Type {
        RAW, BASE64, LIST, MAP
    }

    @Override
    public String toString() {
        return format("SourcePath{name='%s', path='%s', type='%s'}", name, path, type);
    }
}
