package com.example.unit.test.github.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class I18nController {
    private static final Logger LOGGER = LoggerFactory.getLogger(I18nController.class);

    private MessageSource messageSource;

    /**
     * 初始化
     * 在resource下创建i18n文件夹（internationalization国际化，共18个字母简称i18n），
     * 里面创建messages.properties（默认文件，非中、英文时读取）
     * messages_en.properties（英文）
     * messages_zh.properties（中文）
     * @return
     */
    private MessageSource initMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("i18n/messages");
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600);
        return messageSource;
    }

    /**
     * 设置当前的返回信息
     *
     * @param request
     * @param code
     * @return
     */
    public String getMessage(HttpServletRequest request, String code) {
        if (messageSource == null) {
            messageSource = initMessageSource();
        }
        String language = request.getHeader("language");
        //默认没有就是请求地区的语言
        Locale locale = null;
        if (language == null) {
            locale = request.getLocale();
        } else if ("en".equals(language)) {
            locale = Locale.ENGLISH;
        } else if ("zh".equals(language)) {
            locale = Locale.CHINA;
        }
        //其余的不正确的默认就是本地的语言
        else {
            locale = request.getLocale();
        }
        String result = null;
        try {
            result = messageSource.getMessage(code, null, locale);
        } catch (NoSuchMessageException e) {
            LOGGER.error("Cannot find the error message of internationalization, return the original error message.");
        }
        if (result == null) {
            return code;
        }
        return result;
    }

}
