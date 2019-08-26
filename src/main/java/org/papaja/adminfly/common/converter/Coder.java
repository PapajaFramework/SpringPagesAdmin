package org.papaja.adminfly.common.converter;

public interface Coder<A, B> extends Encoder<A, B>, Decoder<B, A> { }
