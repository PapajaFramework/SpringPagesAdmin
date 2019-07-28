package org.papaja.adminfly.mapper.blog;

import org.papaja.adminfly.commons.mapping.Mapper;
import org.papaja.adminfly.dto.blog.DomainDto;
import org.papaja.adminfly.entity.blog.Domain;
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
