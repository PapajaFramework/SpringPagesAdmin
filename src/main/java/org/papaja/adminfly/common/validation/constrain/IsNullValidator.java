package org.papaja.adminfly.common.validation.constrain;

import org.papaja.adminfly.common.validation.Validator;

import java.util.Objects;

public class IsNullValidator implements Validator {

    public boolean isValid(Object value) {
        return Objects.isNull(value);
    }

}
