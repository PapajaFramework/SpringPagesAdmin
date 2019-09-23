package org.papaja.adminfly.module.kv.reposirory;

import org.papaja.adminfly.module.kv.entity.KeyValue;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class KVRepository extends AbstractRepository<KeyValue> {

    @Override
    public Class<KeyValue> getReflection() {
        return KeyValue.class;
    }

}
