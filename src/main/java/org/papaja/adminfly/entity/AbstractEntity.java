package org.papaja.adminfly.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.Objects;

import static java.util.Objects.hash;

@SuppressWarnings({"unused"})
@MappedSuperclass
abstract public class AbstractEntity {

    @Id
    @Positive
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean isNew() {
        return Objects.isNull(id);
    }

    public Boolean isOld() {
        return !isNew();
    }

    @Override
    public int hashCode() {
        return hash(getId(), getClass().getName());
    }
}
