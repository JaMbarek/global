package com.cloud.mvc.example.business.user.security;

import com.cloud.mvc.example.business.user.security.filters.JsonUsernamePasswordAuthenticationFilter;
import com.cloud.mvc.example.business.user.security.handlers.*;
import com.cloud.mvc.example.business.user.security.service.UserDetailsPasswordServiceImpl;
import com.cloud.mvc.example.business.user.security.service.UserDetailsServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoderHandler passwordEncoderHandler;

    @Autowired
    UserDetailsServiceIml userDetailsServiceIml;

    @Autowired
    UserDetailsPasswordServiceImpl userDetailsPasswordService;

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);//当用户信息找不到时是否通知用户，默认不通知，防止暴力破解
        provider.setPasswordEncoder(passwordEncoderHandler);
        provider.setUserDetailsPasswordService(userDetailsPasswordService);
        provider.setUserDetailsService(userDetailsServiceIml);
        return provider;
    }

    @Bean
    public JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter() throws Exception {
        JsonUsernamePasswordAuthenticationFilter  filter = new JsonUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(loginSuccessHandler);
        filter.setAuthenticationFailureHandler(loginFailedHandler);
        return filter;
    }

    @Autowired
    UserAccessDeniedHandler userAccessDeniedHandler;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    LoginFailedHandler loginFailedHandler;

    @Autowired
    UserAuthenticationEntryPoint userAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(userAuthenticationEntryPoint)
                .accessDeniedHandler(userAccessDeniedHandler).and()

                .formLogin()
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailedHandler)
                .permitAll()
                .and()

//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/open").permitAll()
                .antMatchers("*.js").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().permitAll();

        http.addFilterAt(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http
                .headers()
                .frameOptions().sameOrigin()  // required to set for H2 else H2 Console will be blank.
                .cacheControl();

    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
}
