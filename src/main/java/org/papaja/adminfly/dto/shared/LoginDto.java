package org.papaja.adminfly.dto.shared;

import javax.validation.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
