package com.example.unit.test.github.redissonCache.dto;

import com.example.unit.test.github.redissonCache.dto.stereotype.GlobalConstant;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 注册req
 *
 * @author dupan
 */
@Data
@Accessors(chain = true)
public class VerifyCodeSignUpReq extends BaseSignUpReq {

    @NotBlank(message = GlobalConstant.CheckErrCode.CHECK_ERR_CODE_PASSWORD_NO_NULL)
    private String password;

    @NotBlank(message = GlobalConstant.CheckErrCode.CHECK_ERR_CODE_VERIFYCODE_NO_NULL)
    private String verifyCode;

}
