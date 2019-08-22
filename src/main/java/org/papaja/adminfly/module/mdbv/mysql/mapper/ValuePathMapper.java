package org.papaja.adminfly.module.mdbv.mysql.mapper;

import org.papaja.adminfly.common.util.Mapper;
import org.papaja.adminfly.module.mdbv.mysql.dto.ValuePathDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvValuePath;
import org.springframework.stereotype.Component;

import static org.papaja.adminfly.module.mdbv.mysql.entity.MdbvValuePath.Type.valueOf;

@Component
public class ValuePathMapper implements Mapper<ValuePathDto, MdbvValuePath> {

    @Override
    public void map(ValuePathDto source, MdbvValuePath target) {
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setType(valueOf(source.getType()));
    }

    @Override
    public MdbvValuePath get() {
        return new MdbvValuePath();
    }
}
