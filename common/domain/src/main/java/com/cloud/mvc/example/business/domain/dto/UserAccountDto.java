package com.cloud.mvc.example.business.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDto {


    private Long id;

    private String phone;

    private String email;

    private String loginPassword;

    private String dealPassword;

    private Integer lock;

    private Integer status;





}
