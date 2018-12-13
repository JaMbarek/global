package com.cloud.mvc.example.business.user.security.filters;

import com.cloud.mvc.example.business.user.UserApplication;
import com.cloud.mvc.example.business.user.security.beans.UserLoginDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FiltersConfigTest {

    @Autowired
    LocalValidatorFactoryBean bean;

    @Test
    public void test(){
        UserLoginDto dto = new UserLoginDto("", "", "");
        Set<ConstraintViolation<UserLoginDto>> validate = bean.getValidator().validate(dto);
        validate.stream()
                .forEach(t -> System.out.println(t.getMessage()));
    }

}