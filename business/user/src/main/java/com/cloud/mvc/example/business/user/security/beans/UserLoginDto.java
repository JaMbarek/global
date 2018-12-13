package com.cloud.mvc.example.business.user.security.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDto {

    @NotEmpty(message = "{UserLoginDto.username.notEmpty}")
    @Length(max = 50, message = "{UserLoginDto.username.length}")
    private String username;

    @NotEmpty(message = "{UserLoginDto.password.notEmpty}")
    @Length(max = 50, message = "{UserLoginDto.password.length}")
    private String password;

    @NotEmpty(message = "{UserLoginDto.code.notEmpty}")
    @Length(min = 6, max = 6, message = "{UserLoginDto.code.length}")
    private String code;

}
