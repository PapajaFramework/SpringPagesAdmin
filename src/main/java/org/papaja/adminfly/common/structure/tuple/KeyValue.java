package org.papaja.adminfly.common.structure.tuple;

public final class KeyValue<K, V> extends Pair<K, V> {

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
