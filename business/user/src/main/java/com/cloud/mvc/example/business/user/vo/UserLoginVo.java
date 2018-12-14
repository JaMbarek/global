package com.cloud.mvc.example.business.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVo {


    private String phone;
    private String email;

    private String token;

}
