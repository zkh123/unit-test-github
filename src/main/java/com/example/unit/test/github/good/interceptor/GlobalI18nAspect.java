package com.example.unit.test.github.good.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.unit.test.github.good.ConfigProperties;
import com.example.unit.test.github.good.constant.ResponseConstant;
import com.example.unit.test.github.good.response.MobiBaseResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;

@Aspect
@Component
public class GlobalI18nAspect {
    @Autowired
    private ConfigProperties configProperties;
    @Autowired
    private MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(GlobalI18nAspect.class);

    @AfterReturning(pointcut="execution(* com.example.unit.test.github.controller..*(..))", returning="result")
    public void afterReturning(JoinPoint joinPoint , Object result)  {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = request.getLocale();
        if (result instanceof MobiBaseResponse) {
            Map<String, Integer> mapping = configProperties.getMapping();
            MobiBaseResponse response = (MobiBaseResponse) result;
            String code = response.getResultMessage();
            Integer resResult = response.getResult();
            //返回系统异常
            if(code == null && resResult == null){
                code  = ResponseConstant.FAILED_VALUE;
            }
            if(mapping.get(code) != null){
                response.setResult(mapping.get(code));
                response.setResultMessage(messageSource.getMessage(code,response.getExtParam(), locale));
            }
            logger.info("文案统一处理aspect [{}]", JSON.toJSONString(response));
        }
    }


}
