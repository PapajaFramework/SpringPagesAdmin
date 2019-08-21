package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.adminfly.common.mapping.Mapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.ValuePathDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.ValuePath;
import org.springframework.stereotype.Component;

import static org.papaja.adminfly.module.mdbv.mysql.entity.ValuePath.Type.valueOf;

@Component
public class ValuePathMapper implements Mapper<ValuePathDto, ValuePath> {

    @Override
    public void map(ValuePathDto source, ValuePath target) {
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setType(valueOf(source.getType()));
    }

    @Override
    public ValuePath get() {
        return new ValuePath();
    }
}
