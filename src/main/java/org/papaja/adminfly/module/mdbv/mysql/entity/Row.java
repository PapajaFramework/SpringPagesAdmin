package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.common.converter.Format;
import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "mdbv_rows")
public class Row extends AbstractEntity {

    @Column(name = "path")
    private String path;

    @Column(name = "d_type", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    private Source source;

    @Column(name = "name")
    private String name;

    @Column(name = "type", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Format type;

    @Column(name = "position")
    private Integer position;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isFull() {
        return Status.F.equals(status);
    }

    public boolean isShort() {
        return !isFull();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Format getType() {
        return type;
    }

    public void setType(Format type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public enum Status {S, F}

}
