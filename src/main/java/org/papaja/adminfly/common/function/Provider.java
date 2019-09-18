package org.papaja.adminfly.common.function;

@FunctionalInterface
public interface Provider<K, R> {
    R get(K key);
}
