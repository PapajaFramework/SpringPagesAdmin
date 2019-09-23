package org.papaja.adminfly.module.kv.mapper;

import org.papaja.adminfly.module.kv.dto.KeyValueDto;
import org.papaja.adminfly.module.kv.entity.KeyValue;
import org.papaja.commons.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class KVMapper implements Mapper<KeyValueDto, KeyValue> {

    @Override
    public void map(KeyValueDto source, KeyValue target) {
        target.setKey(source.getKey().toUpperCase());
        target.setValue(source.getValue());
    }

    @Override
    public KeyValue get() {
        return new KeyValue();
    }

}
