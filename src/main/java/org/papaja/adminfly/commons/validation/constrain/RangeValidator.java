package org.papaja.adminfly.commons.validation.constrain;

public class RangeValidator extends SequenceValidator<Long> {

    public RangeValidator(Long min, Long max) {
        super(new MinValidator(min), new MaxValidator(max));
    }

}
