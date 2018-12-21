package com.cloud.mvc.example.business.common.config.refresh;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@ConfigurationProperties(prefix = "custom")
public class RefreshBean {



    private Long id;
    private String name;
    private Integer status;


}
