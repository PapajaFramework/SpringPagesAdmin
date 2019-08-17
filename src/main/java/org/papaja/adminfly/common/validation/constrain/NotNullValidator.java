package org.papaja.adminfly.common.validation.constrain;

public class NotNullValidator extends IsNullValidator {

    @Override
    public boolean isValid(Object value) {
        return !super.isValid(value);
    }

}
