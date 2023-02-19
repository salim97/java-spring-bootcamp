package com.pg1.pg1helloworldspringboot;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResetPasswordDTO {
    private String email;
    private String languageCode;
}
