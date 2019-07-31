package org.papaja.adminfly.commons.validation.constrain;

import org.papaja.adminfly.commons.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class SequenceValidator<T> implements Validator<T> {

    private List<Validator<T>> validators;

    public SequenceValidator(List<Validator<T>> validators) {
        this.validators = validators;
    }

    public SequenceValidator(Validator... validators) {
        this(Arrays.asList(validators));
    }

    @Override
    public boolean isValid(T value) {
        return validators.stream()
                .reduce(true, (b, validator) -> b && validator.isValid(value), Boolean::logicalAnd);
    }

}
