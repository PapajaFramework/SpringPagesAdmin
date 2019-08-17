package org.papaja.adminfly.common.validation;

public interface Validator<T> {

    boolean isValid(T value);

}
