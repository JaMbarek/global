package com.cloud.mvc.example.business.domain.dto.user;


import com.cloud.mvc.example.business.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto extends BaseDto {


    private Long id;

    private String phone;

    private String email;

    private String loginPassword;

    private String dealPassword;

    private Integer lock;

    private Integer status;





}
