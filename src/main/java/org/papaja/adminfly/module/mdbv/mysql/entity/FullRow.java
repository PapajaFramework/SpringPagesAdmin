package org.papaja.adminfly.module.mdbv.mysql.entity;

import org.papaja.adminfly.common.converter.Format;

import javax.persistence.*;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "mdbv_paths")
@DiscriminatorValue("F")
public class FullRow extends Row {

    @Column(name = "name")
    private String name;

    @Column(name = "type", columnDefinition = "CHAR")
    @Enumerated(EnumType.STRING)
    private Format type;

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

}
