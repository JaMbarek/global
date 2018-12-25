package com.cloud.mvc.example.business.domain.dto.user;

import com.cloud.mvc.example.business.domain.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto extends BaseDto {


    private String name;

}
