package org.papaja.adminfly.commons.validation.constrain;

import org.papaja.adminfly.commons.validation.Validator;

import java.util.function.Function;

public class CallableValidator<T> implements Validator<T> {

    private Function<T, Boolean> validator;

    public CallableValidator(Function<T, Boolean> validator) {
        this.validator = validator;
    }

    @Override
    public boolean isValid(T value) {
        return validator.apply(value);
    }
}
