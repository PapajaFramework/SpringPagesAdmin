package org.papaja.adminfly.entity.blog;

import org.papaja.adminfly.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "blog_categories")
public class Category extends AbstractEntity {

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="domain_id")
    private Domain domain;

    @Column(name = "name")
    private String name;

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Category{domain=%s, name='%s'}", domain, name);
    }
}
