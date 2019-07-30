package org.papaja.adminfly.entity.blog;

import org.papaja.adminfly.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "blog_categories")
public class Category extends AbstractEntity {

    @OneToOne(cascade = {
            CascadeType.PERSIST, CascadeType.MERGE
    }, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="domain_id")
    private Domain domain;

    @NotBlank(message = "{validation.notBlank}")
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
