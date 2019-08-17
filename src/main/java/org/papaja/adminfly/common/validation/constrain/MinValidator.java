package org.papaja.adminfly.common.validation.constrain;

import org.papaja.adminfly.common.validation.Validator;

public class MinValidator implements Validator<Long> {

    private Long min;

    public MinValidator(Long min) {
        this.min = min;
    }

    @Override
    public boolean isValid(Long value) {
        return value > min;
    }

}
