package org.papaja.adminfly.entity.security;

import org.papaja.adminfly.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@SuppressWarnings({"unused"})
@Entity
@Table(name = "security_privileges")
public class Privilege extends AbstractEntity {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 3, max = 64, message = "{validation.size}")
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Privilege{id=%d, name='%s'}", id, name);
    }
}
