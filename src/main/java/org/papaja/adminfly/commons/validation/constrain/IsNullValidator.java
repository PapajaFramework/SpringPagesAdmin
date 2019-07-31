package org.papaja.adminfly.commons.validation.constrain;

import org.papaja.adminfly.commons.validation.Validator;

import java.util.Objects;

public class IsNullValidator implements Validator {

    public boolean isValid(Object value) {
        return Objects.isNull(value);
    }

}
