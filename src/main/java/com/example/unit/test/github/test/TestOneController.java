package com.example.unit.test.github.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class TestOneController {

    //验证码校验
    @ResponseBody
    @RequestMapping(value = {"checkCode"}, method = RequestMethod.POST)
    public MobiContentResponse<PublishResponseV3> checkCode(@RequestParam(value = "messageCode") String messageCode){
        MobiContentResponse<PublishResponseV3> response = new MobiContentResponse<PublishResponseV3>();
        PublishResponseV3 publishResponseV3 = new PublishResponseV3();
        try {
            if (!StringUtils.isBlank(messageCode)){
                CheckVerifyCodeReq checkVerifyCodeReq = new CheckVerifyCodeReq();
                checkVerifyCodeReq.setVerifyCode(messageCode);
//                BasicResponse<Boolean> booleanBasicResponse = remoteLoginService.checkVerifyCode(checkVerifyCodeReq);

                BasicResponse<Boolean> basicResponse = new BasicResponse();
                basicResponse.isSuccess();
                basicResponse.setData(true);
                BasicResponse<Boolean> booleanBasicResponse = basicResponse;

                if (booleanBasicResponse.isSuccess()){
                    response.setResult(1);
                }response.setResult(0);
                publishResponseV3.setIsSendMessageCode(booleanBasicResponse.getData());
            }
            response.setContent(publishResponseV3);
        }catch (Exception e){
            response.setResult(0);
        }
        return response;
    }

}
