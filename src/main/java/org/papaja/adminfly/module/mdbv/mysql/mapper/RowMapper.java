package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.commons.util.Mapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.RowDto;
import org.papaja.commons.converter.Format;
import org.papaja.adminfly.module.mdbv.mysql.entity.Row;
import org.springframework.stereotype.Component;

@Component
public class RowMapper implements Mapper<RowDto, Row> {

    @Override
    public void map(RowDto source, Row target) {
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setPosition(source.getPosition());
        target.setType(Format.valueOf(source.getType()));
    }

    @Override
    public Row get() {
        return new Row();
    }
}
