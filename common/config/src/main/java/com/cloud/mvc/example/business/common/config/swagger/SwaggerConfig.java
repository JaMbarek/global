package com.cloud.mvc.example.business.common.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String name;

    private ApiInfo apiInfo(String groupName) {
        return new ApiInfoBuilder()
                .title(name +" 模块接口文档")
                .description(groupName +" API接口列表")
                .termsOfServiceUrl("http://m-chain.com/")
                .contact(new Contact("m-chain", "", ""))
                .version("1.0")
                .build();
    }

    @Bean
    public Docket consoleDocker(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(name))
                .select()
                .paths(PathSelectors.any())
                .build();
    }




}
