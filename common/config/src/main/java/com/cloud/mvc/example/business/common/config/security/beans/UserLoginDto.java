package com.cloud.mvc.example.business.common.config.security.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    @NotEmpty(message = "{UserLoginDto.phone.notEmpty}")
    @Length(max = 50, message = "{UserLoginDto.phone.length}")
    private String phone;

    @NotEmpty(message = "{UserLoginDto.password.notEmpty}")
    @Length(max = 50, message = "{UserLoginDto.password.length}")
    private String password;

    @NotEmpty(message = "{UserLoginDto.code.notEmpty}")
    @Length(min = 6, max = 6, message = "{UserLoginDto.code.length}")
    private String code;

}
