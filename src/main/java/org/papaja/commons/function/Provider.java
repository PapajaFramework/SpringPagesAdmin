package org.papaja.commons.function;

@FunctionalInterface
public interface Provider<K, R> {
    R get(K key);
}
