package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.*;

import static org.papaja.adminfly.module.mdbv.mysql.entity.Row.DType.F;

@SuppressWarnings("unused")
@Entity
@Table(name = "mdbv_paths")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "d_type", columnDefinition = "CHAR")
public class Row extends AbstractEntity {

    @Column(name = "path")
    private String path;

    @Column(name = "d_type", columnDefinition = "CHAR", insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private DType dType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
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

    public boolean isFull() {
        return F.equals(dType);
    }

    public boolean isShort() {
        return !isFull();
    }

    public enum DType {S, F}

}
