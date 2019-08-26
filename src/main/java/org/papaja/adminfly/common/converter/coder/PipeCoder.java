package org.papaja.adminfly.common.converter.coder;

import org.papaja.adminfly.common.converter.Coder;

import java.util.List;

import static java.util.Arrays.asList;

public class PipeCoder implements Coder {

    List<Coder> coders;

    private PipeCoder(Coder... coders) {
        this.coders = asList(coders);
    }

    public static PipeCoder of(Coder... coders) {
        return new PipeCoder(coders);
    }

    @Override
    public Object decode(Object source) {
        Object target = source;

        for (int index = coders.size() - 1; 0 <= index; index--) {
            target = coders.get(index).decode(target);
        }

        return target;
    }

    @Override
    public Object encode(Object source) {
        Object target = source;

        for (Coder coder : coders) {
            target = coder.encode(target);
        }

        return target;
    }

}
