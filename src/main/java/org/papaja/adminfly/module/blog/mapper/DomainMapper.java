package org.papaja.adminfly.module.blog.mapper;

import org.papaja.adminfly.module.blog.dto.DomainDto;
import org.papaja.adminfly.module.blog.entity.Domain;
import org.papaja.adminfly.common.mapping.Mapper;
import org.springframework.stereotype.Component;

@Component
public class DomainMapper implements Mapper<DomainDto, Domain> {

    @Override
    public void map(DomainDto source, Domain target) {
        target.setName(source.getName().toUpperCase());
        target.setDomain(source.getDomain());
    }

    @Override
    public Domain get() {
        return new Domain();
    }

}
