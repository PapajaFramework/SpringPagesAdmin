package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.adminfly.common.util.Mapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.RowDto;
import org.papaja.adminfly.common.converter.Format;
import org.papaja.adminfly.module.mdbv.mysql.entity.FullRow;
import org.springframework.stereotype.Component;

@Component
public class RowMapper implements Mapper<RowDto, FullRow> {

    @Override
    public void map(RowDto source, FullRow target) {
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setType(Format.valueOf(source.getType()));
    }

    @Override
    public FullRow get() {
        return new FullRow();
    }
}
