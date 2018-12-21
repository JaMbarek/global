package com.cloud.mvc.example.business.common.config.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;
import java.util.Properties;

/**
 * 错误码消息配置
 */
@Configuration
public class CodeMessagesResourceConfiguration {


    @Value("${spring.application.name}")
    private String serviceName;


    @Bean("codeMessageResourceBundle")
    public ReloadableResourceBundleMessageSource codeMessageResourceBundle() {
        ReloadableResourceBundleMessageSource rbms = new ReloadableResourceBundleMessageSource();
        rbms.setDefaultEncoding("UTF-8");
        rbms.setBasenames("classpath:messages/messages", "classpath:messages/" + serviceName + "Messages");
        Properties p = new Properties();
        p.setProperty("defaultEncoding", "UTF-8");
        rbms.setFileEncodings(p);
        return rbms;
    }


}
