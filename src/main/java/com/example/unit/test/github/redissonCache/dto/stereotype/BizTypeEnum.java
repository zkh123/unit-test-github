package com.example.unit.test.github.redissonCache.dto.stereotype;


/**
 * 这个系统所包含的业务
 * @author chenjianzhou
 */
public enum BizTypeEnum {
    SIGN_IN,
    SIGN_UP,
    /**
     * 语音注册
     */
    SIGN_UP_VOICE,
    SIGN_OUT,
    RESET_PWD,
    /**
     * 语音重置密码
     */
    RESET_PWD_VOICE,
    FORGET_PWD,

    /**
     * 解换绑手机号
     */
    RELEASE_MOBILE,
    BIND_MOBILE,

    /**
     * 发标前做短信验证
     */
    PRE_PUBLISH_VERIFY,
    /**
     * 发标前做语音短信验证
     */
    PRE_PUBLISH_VOICE_VERIFY,
    ChangeBankCard,
    /**
     * 邮箱验证
     */
    EMAIL_VALIDATE,

    /**
     * 验证码登录
     */
    VERIFY_CODE_LOGON,
    /**
     * 验证码登录
     */
    VERIFY_CODE_LOGON_VOICE;;
    ;
}
