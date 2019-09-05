package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.hibernate.annotations.SQLInsert;
import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "mdbv_scanned")
@SQLInsert(sql="INSERT IGNORE INTO mdbv_scanned(`path`, `source_id`) VALUES(?, ?)")
public class ScannedPath extends AbstractEntity {

    @Column(name = "path")
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="source_id")
    private Source source;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return String.format("ScannedPath{id=%s, path='%s', source=%s}", id, path, source.getName());
    }
}
