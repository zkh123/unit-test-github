package com.example.unit.test.github.good.interceptor;

import com.example.unit.test.github.good.constant.ResponseConstant;
import com.example.unit.test.github.good.response.MobiBaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangzhenyu
 * @description
 * @Date 2019/9/24 20:52
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public MobiBaseResponse handleException(Exception e) {
        log.error("捕获到全局异常：{}", e);
        MobiBaseResponse response = new MobiBaseResponse();
        response.setResult(ResponseConstant.FAILED_CODE);
        response.setResultMessage("The system is busy, please try again later.");
        return response;
    }
}
