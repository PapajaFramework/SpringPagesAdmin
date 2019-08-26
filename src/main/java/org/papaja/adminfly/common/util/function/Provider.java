package org.papaja.adminfly.common.util.function;

public interface Provider<K, R> extends Function<K, R> {

    R get(K key);

    @Override
    default R apply(K key) {
        return get(key);
    }
}
