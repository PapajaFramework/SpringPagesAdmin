package org.papaja.adminfly.commons.validation.constrain;

import org.papaja.adminfly.commons.validation.Validator;

public class MaxValidator implements Validator<Long> {

    private Long max;

    public MaxValidator(Long max) {
        this.max = max;
    }

    @Override
    public boolean isValid(Long value) {
        return value < max;
    }

}
