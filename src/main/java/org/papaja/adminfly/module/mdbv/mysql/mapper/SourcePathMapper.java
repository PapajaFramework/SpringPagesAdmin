package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.adminfly.common.util.Mapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.SourcePathDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.SourcePath;
import org.springframework.stereotype.Component;

import static org.papaja.adminfly.module.mdbv.mysql.entity.SourcePath.Type.valueOf;

@Component
public class SourcePathMapper implements Mapper<SourcePathDto, SourcePath> {

    @Override
    public void map(SourcePathDto source, SourcePath target) {
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setType(valueOf(source.getType()));
    }

    @Override
    public SourcePath get() {
        return new SourcePath();
    }
}
