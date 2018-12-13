package com.cloud.mvc.example.business.common.config.message;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

@Component
public class MessageUtils {


    static private AcceptHeaderLocaleResolver resolver;
    static private ReloadableResourceBundleMessageSource codeAndMessageSource;


    public MessageUtils(
            @Autowired @Qualifier("codeMessageResourceBundle") ReloadableResourceBundleMessageSource source

                        ) {
        MessageUtils.resolver = new AcceptHeaderLocaleResolver();
        MessageUtils.resolver.setDefaultLocale(Locale.CHINA);
        MessageUtils.codeAndMessageSource = source;
        MessageUtils.resolver.setSupportedLocales(Lists.newArrayList(Locale.CHINA, Locale.US, Locale.JAPAN));
    }

    public static List<Locale> supports(){
        return resolver.getSupportedLocales();
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
        return codeAndMessageSource.getMessage(code, null, locale);
    }


    public static String getMessageByRequest(String code, HttpServletRequest request) {
        Locale locale = resolver.resolveLocale(request);
        return codeAndMessageSource.getMessage(code, null, locale);
    }


}
