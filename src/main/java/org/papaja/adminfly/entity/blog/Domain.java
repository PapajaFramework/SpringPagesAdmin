package org.papaja.adminfly.entity.blog;

import org.papaja.adminfly.entity.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "blog_domains")
public class Domain extends AbstractEntity {

    @Column(name = "name")
    private String name;

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
