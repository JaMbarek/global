package com.cloud.mvc.example.business.common.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String name;

    private ApiInfo apiInfo(String groupName) {
        return new ApiInfoBuilder()
                .title(name +" 模块接口文档")
                .description(groupName +" API接口列表")
                .termsOfServiceUrl("http://cloud.test.com/")
                .contact(new Contact("cloud", "", ""))
                .version("1.0")
                .build();
    }

    @Bean
    public Docket consoleDocker(){
        return new Docket(DocumentationType.SWAGGER_2)
                .host("cloud.test.com:10005/system") //gateway中会过滤掉服务前缀，这里在实例中添加前缀
                .globalOperationParameters(parameters())
                .apiInfo(apiInfo(name))
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private List<Parameter> parameters() {
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder languagePar = new ParameterBuilder();
        languagePar.name("Accept-Language").description("语言").modelRef(new ModelRef("string")).parameterType("header").required(false).
                defaultValue("zh-CN,zh").build();
        //Authorization
        languagePar.name("Authorization").description("token 以Bearer (<-这里存在空格)开头").modelRef(new ModelRef("string")).parameterType("header")
                .required(false). defaultValue("").build();

        ParameterBuilder pagePar = new ParameterBuilder();
        pagePar.name("page").description("当前页(需分页的接口使用)").modelRef(new ModelRef("string")).parameterType("header").required(false)
                .defaultValue("1").build();
        ParameterBuilder limitPar = new ParameterBuilder();
        limitPar.name("limit").description("当前页条数(需分页的接口使用)").modelRef(new ModelRef("string")).parameterType("header").required(false)
                .defaultValue("10").build();

        pars.add(languagePar.build());
        pars.add(pagePar.build());
        pars.add(limitPar.build());
        return pars;
    }


}
