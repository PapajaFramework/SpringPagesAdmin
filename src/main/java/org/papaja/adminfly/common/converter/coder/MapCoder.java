package org.papaja.adminfly.common.converter.coder;

import java.util.Map;

public class MapCoder extends ArrayJsonCoder<Map> {

    @Override
    public Class<Map> getArrayClass() {
        return Map.class;
    }

}
