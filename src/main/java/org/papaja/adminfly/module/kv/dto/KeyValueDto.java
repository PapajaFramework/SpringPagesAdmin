package org.papaja.adminfly.module.kv.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class KeyValueDto {

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 2, max = 64, message = "{validation.size}")
    @Pattern(regexp="[\\w\\d_]+", message = "{validation.regex}")
    private String key;

    @NotBlank(message = "{validation.notBlank}")
    @Size(min = 2, max = 32, message = "{validation.size}")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("KeyValueDto{key='%s', value='%s'}", key, value);
    }

}
