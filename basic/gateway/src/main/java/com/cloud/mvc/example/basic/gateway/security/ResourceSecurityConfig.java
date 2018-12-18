//package com.cloud.mvc.example.basic.gateway.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.ObjectPostProcessor;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//import javax.servlet.http.HttpServletResponse;
//
//@Configuration
////@EnableResourceServer
//public class ResourceSecurityConfig extends ResourceServerConfigurerAdapter {
//
//
////    @Autowired
////    private AccessDeniedHandler accessDeniedHandler;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .exceptionHandling()
////                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
////                .and()
////                .authorizeRequests()
////                .anyRequest().authenticated()
////                .and()
////                .httpBasic();
//    }
//
//
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//    }
//
////    @Bean
//    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(
//            ApplicationContext applicationContext) {
//        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
//        expressionHandler.setApplicationContext(applicationContext);
//        return expressionHandler;
//    }
//
//
//}
