package com.example.unit.test.github.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.unit.test.github.good.constant.ResponseConstant;
import com.example.unit.test.github.good.response.MobiContentResponse;
import com.sun.istack.internal.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "out")
@RestController
@Slf4j
public class OutController {


    /**
     * {"result":-1,"resultMessage":"The system is busy, please try again later."}
     * @return
     */
    @GetMapping(value = "/test")
    public Object test(){
        int param = 1/0;
        return "ok";
    }


    /**
     * {"result":101023,"resultMessage":"黄大大测试","content":{"isVerified":null,"token":"erlkhtler22222222hlkhtryljtry","leftRetryTimes":0}}
     * @return
     */
    @GetMapping("/test1")
    @ResponseBody
    public MobiContentResponse test1() {
        MobiContentResponse response = new MobiContentResponse();
        String token = "erlkhtler22222222hlkhtryljtry";
        SmsValidateResponse content = SmsValidateResponse
                .builder()
                .token(token)
                .build();
        response.setResult(ResponseConstant.SUCCESS_CODE); //无效代码
        response.setResultMessage(ResponseConstant.HLJ_TEST);  //主
        response.setContent(content);
        log.info("接口返回: " + JSONObject.toJSONString(response));
        return response;
    }


    /**
     * {"result":9999,"resultMessage":"请在3再试一次------9,999.","content":{"isVerified":true,"token":"eporujytjhrt9845068790jfglkhjlfgjh","leftRetryTimes":0}}
     * @return
     */
    @GetMapping("/test2")
    @ResponseBody
    public MobiContentResponse test2() {
        MobiContentResponse response = new MobiContentResponse();
        String token = "eporujytjhrt9845068790jfglkhjlfgjh";
        SmsValidateResponse content = SmsValidateResponse
                .builder()
                .token(token)
                .build();
        response.setResultMessage(ResponseConstant.LOAN_FORBIDDEN);
        content.setIsVerified(true);

        Object[] objects = new Object[2];
        objects[0] = 3;
        objects[1] = 9999;
        response.setExtParam(objects);

        response.setContent(content);
        log.info("接口返回: " + JSONObject.toJSONString(response));
        return response;
    }



    /**
     * 入参
     */
    @Getter
    @Setter
    static class SmsValidateRequest {
        @NotNull
        private String mobile;
        @NotNull
        private String verifyCode;
        @NotNull
        private Integer msgType;
    }

    /**
     * 出参
     */
    @Getter
    @Setter
    @Builder
    static class SmsValidateResponse {
        private Boolean isVerified;
        @NotNull
        private String token;
        private long leftRetryTimes;
    }

}
