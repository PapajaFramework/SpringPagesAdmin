package org.papaja.commons.validation;

import java.util.Arrays;
import java.util.List;

public class Constrains<T> {

    private Message            message;
    private List<Validator<T>> validators;

    public Constrains(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public void addValidators(List<Validator<T>> validators) {
        validators.forEach(this::addValidator);
    }

    public void addValidators(Validator<T>... validators) {
        addValidators(Arrays.asList(validators));
    }

    public void addValidator(Validator<T> validator) {
        validators.add(validator);
    }

    public List<Validator<T>> getValidators() {
        return validators;
    }

}
