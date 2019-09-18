package org.papaja.commons.validation;

public interface Validator<T> {

    boolean isValid(T value);

}
