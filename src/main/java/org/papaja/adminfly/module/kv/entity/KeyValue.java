package org.papaja.adminfly.module.kv.entity;

import org.papaja.adminfly.shared.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "kv_values")
public class KeyValue extends AbstractEntity {

    @Column(name = "name")
    private String key;

    @Column(name = "value")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("KeyValue{key='%s', value='%s'}", key, value);
    }
}
