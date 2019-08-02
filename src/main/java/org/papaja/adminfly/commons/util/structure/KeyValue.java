package org.papaja.adminfly.commons.util.structure;

public final class KeyValue<K, V> extends BiValue<K, V> {

    public KeyValue(K k, V v) {
        super(k, v);
    }

    public K getKey() {
        return getA();
    }

    public V getValue() {
        return getB();
    }

}
