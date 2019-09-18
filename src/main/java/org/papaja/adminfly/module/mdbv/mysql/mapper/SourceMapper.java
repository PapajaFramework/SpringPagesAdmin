package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.commons.util.Mapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.SourceDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.Source;
import org.springframework.stereotype.Component;

@Component
public class SourceMapper implements Mapper<SourceDto, Source> {

    @Override
    public void map(SourceDto source, Source target) {
        target.setName(source.getName());
        target.setCollection(source.getCollection());
        target.setDatabase(source.getDatabase());
    }

    @Override
    public Source get() {
        return new Source();
    }

}
