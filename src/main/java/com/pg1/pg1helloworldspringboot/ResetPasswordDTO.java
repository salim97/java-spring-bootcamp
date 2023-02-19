package com.pg1.pg1helloworldspringboot;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
@Setter
@Getter
public class ResetPasswordDTO {

    @Email
    private String email;
    private String languageCode;
}
