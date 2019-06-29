package org.papaja.adminfly.entity.blog;

import org.papaja.adminfly.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "blog_domains")
public class Domain extends AbstractEntity {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 5, max = 16, message = "{validation.size}")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 5, max = 16, message = "{validation.size}")
    @Column(name = "domain")
    private String domain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return String.format("Domain{name='%s', domain='%s'}", name, domain);
    }
}
