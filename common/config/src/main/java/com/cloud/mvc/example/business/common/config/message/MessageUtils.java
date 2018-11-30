package com.cloud.mvc.example.business.common.config.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Component
public class MessageUtils {


    static private AcceptHeaderLocaleResolver resolver;
    static private ReloadableResourceBundleMessageSource source;

    public MessageUtils(@Autowired ReloadableResourceBundleMessageSource source) {
        MessageUtils.resolver = new AcceptHeaderLocaleResolver();
        MessageUtils.resolver.setDefaultLocale(Locale.CHINA);
        MessageUtils.source = source;
    }

    /**
     * 根据request中的请求头读取资源文件的信息内容
     * @param code
     * @return
     */
    public static String getMessageByRequest(String code) {
        ServletRequestAttributes  attributes = (ServletRequestAttributes )RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Locale locale = resolver.resolveLocale(request);
        return source.getMessage(code, null, locale);
    }


}
