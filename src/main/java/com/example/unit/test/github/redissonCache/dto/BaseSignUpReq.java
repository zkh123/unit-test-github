package com.example.unit.test.github.redissonCache.dto;

import com.example.unit.test.github.redissonCache.dto.stereotype.BizTypeEnum;
import com.example.unit.test.github.redissonCache.dto.stereotype.GlobalConstant;
import com.example.unit.test.github.redissonCache.dto.stereotype.LoginTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
public class BaseSignUpReq extends BaseReq {

    @NotNull(message = GlobalConstant.CheckErrCode.CHECK_ERR_CODE_LOGINTYPE_NO_NULL)
    private LoginTypeEnum loginType;

    @NotBlank(message = GlobalConstant.CheckErrCode.CHECK_ERR_CODE_ACCOUNT_NO_NULL)
    private String accountName;

    private Integer roleType;

    private BizTypeEnum bizType = BizTypeEnum.SIGN_UP;

}
