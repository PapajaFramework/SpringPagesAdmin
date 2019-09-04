package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.hibernate.annotations.SQLInsert;
import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mdbv_scanned")
@SQLInsert(sql="INSERT IGNORE INTO mdbv_scanned(name) VALUES(?)")
public class Scanned extends AbstractEntity {

    @Column(name = "path")
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
