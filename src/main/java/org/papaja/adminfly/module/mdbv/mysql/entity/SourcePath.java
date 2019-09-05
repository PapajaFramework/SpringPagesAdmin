package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.common.converter.Format;
import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
@Table(name = "mdbv_paths")
public class SourcePath extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "type", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Format type;

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

    public Format getType() {
        return type;
    }

    public void setType(Format type) {
        this.type = type;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return format("SourcePath{name='%s', path='%s', type='%s'}", name, path, type);
    }
}
