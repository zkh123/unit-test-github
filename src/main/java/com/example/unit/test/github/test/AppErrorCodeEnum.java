package com.example.unit.test.github.test;

import lombok.Getter;

@Getter
public enum AppErrorCodeEnum {
    SUCCESS(0, "success.value"),//成功
    FAILED(-1, "failed.value"), //失败
    PARAMETER_ERROR(-2, "参数异常"),//参数异常
    RELOGIN(-99, "登录令牌失效,请重新登录"),//登录过期,重新登录
    EXCEPTION(-100, "系统繁忙,请稍后再试"),//系统繁忙
    AUTH_REQUEST_PARAM_ERROR(-90, "基础参数appId缺失"),
    AUTH_REQUEST_ILLEGAL(-91, "未知来源请求"),//请求不是来自合法的app或者H5请求不在允许范围内的接口
    AUTH_VERIFY_SIGN_FAIL(-92, "验签失败"),//验签失败
    AUTH_REQUEST_REPEAT(-93, "重复提交"),//重复提交或者刷接口

    /**
     * api
     */
    API_ERROR_PUB_001(AppErrorCodeEnum.FAILED.getCode(), "API.ERROR.PUB.001"),//系统升级
    API_ERROR_PARAMETER_000(AppErrorCodeEnum.FAILED.getCode(), "API.ERROR.PARAMETER.000"),//系统异常请稍后再试
    API_ERROR_LOANAPPLY_LIMIT(101028, "API.ERROR.LOANAPPLY_LIMIT"),//您的综合评分不足，暂时无法借款
    API_ERROR_SYSTEM_000(AppErrorCodeEnum.FAILED.getCode(), "API.ERROR.SYSTEM.000"),//系统繁忙请稍后再试

    /**
     * pipeline error code
     */
    PIPE_ERR_RATE_001(101001, "PIPE.ERR.RATE.001"),//传入费率有误
    USER_NOT_BIND_CARD(101002, "USER_NOT_BIND_CARD"),//该用户未绑卡
    PIPE_ERR_LIST_007(101003, "PIPE.ERR.LIST.007"),//该用户存在正常未还的标的
    PIPE_ERR_LIST_006(101004, "PIPE.ERR.LIST.006"),//用户存在逾期的标的
    PIPE_ERR_LIST_001(101005, "PIPE.ERR.LIST.001"),//已经存在进行中标的
    PIPE_ERR_LIST_008(101006, "PIPE.ERR.LIST.008"),//ktp被xxxx尾号绑定，暂时无法发标
    PIPE_ERR_LIST_ADAM_008(101006, "PIPE.ERR.LIST.ADAM.008"),//ktp被xxxx尾号绑定，暂时无法发标
    PIPE_ERR_LIST_009(101007, "PIPE.ERR.LIST.009"),//此银行卡下有其他的账户有进行中的借款,暂时无法发标
    PIPE_ERR_USER_005(101029, "PIPE.ERR.USER.005"),//禁言

    USER_UPDATE_MOBILE_CONFLICT(101006, "USER.ERR.UPDATEMOBILE.001"),//换绑手机流程中新手机已被其他用户绑定
    USER_UPDATE_MOBILE_OPERATE_TIMEOUT(101007, "USER.ERR.UPDATEMOBILE.002"),//用户换绑流程操作过长
    USER_KTP_USED(101008, "USER.ERR.KTP.002"),//用户当前提交ktp已被其他用户绑定
    USER_KTP_USED_ADA_M(101008, "USER.ERR.KTP.ADAM.002"),//用户当前提交ktp已被其他用户绑定,candypay提示文案不一样，不提供更换手机号的功能
    EMPTY_FEE_PLZ_REFRESH(101009, "PIPE.ERR.RATE.002"), // 100需要用户下拉刷新fee_table
    AMOUNT_NOT_INITIALIZED(101010, "USER.ERR.AMOUNT.NOT.INITIALIZED"), //用户额度还未评估完成，正在首次评估额度过程中或还未戳额
    DIGISIGN_ACTIVE_FAIL(101012, "USER.ERR.DIGISIGN.ACTIVE.FAIL"), //前端报告用户激活完成，但后端检查发现激活失败
    DIGISIGN_SIGN_FAIL(101013, "USER.ERR.DIGISIGN.SIGN.FAIL"), //前端报告用户完成电子签名，但后端检查发现签名失败
    USER_EMAIL_CONFLICT(101014, "USER.ERR.EMAIL.CONFLICT"), //用户填写的邮箱已被其他人使用
    DIGISIGN_SIGN_CONFLICT(101015, "USER.ERR.DIGISIGN.SIGN.CONFLICT"), //用户填写的邮箱已被其他人使用

    KTP_AUTH_FAIL(101021, "USER.ERR.KTP.004"),//ktp认证失败
    KTP_AUTH_BYD_LIM(101022, "USER.ERR.KTP.003"),//ktp认证超过次数限制
    KTP_AUTH_REPETITION(101023, "USER.ERR.KTP.002"),//ktp重复
    KTP_NAME_MODIFY_CHECK_ERROR(101032, "USER.ERR.KTP.008"),
    KTP_NO_MODIFY_CHECK_ERROR(101033, "USER.ERR.KTP.009"),
    KTP_MODIFY_LIM(101034, "USER.ERR.KTP.010"),


    /*
     * USERSIGNON.ERROR.SMS_SEND_LIMIT
     */
    SMS_SEND_LIMIT(-1, "USERSIGNON.ERROR.SMS_SEND_LIMIT"), // 短信次数达到上限
    SMS_VERIFYCODE_ERROR(-1, "USERSIGNON.ERROR.SMS_VERIFYCODE_ERROR"), // 验证码错误
    SMS_VERIFYCODE_REGISTERED(-1, "USERSIGNON.ERROR.REGISTERED"), // 验证码错误


    //投标接口返回
    LOAN_BID_ERROR_LOANLIST_NOT_EXIST(101016,"LOANLIST_NOT_EXIST"),
    LOAN_BID_ERROR_AWAIT_SIGNING(101017,"AWAIT_SIGNING"),
    LOAN_BID_ERROR_BALANCE_NOT_ENOUGH(101018,"BALANCE_NOT_ENOUGH"),
    LOAN_BID_ERROR_FULLBID_ALREADY(101019,"FULLBID_ALREADY"),
    LOAN_BID_ERROR_RDL_NOT_EXIST(101020,"RDL_NOT_EXIST"),
    LOAN_BID_ERROR_DIGITALSIGN_NOT_ACTIVATED(101024,"DIGITALSIGN_NOT_ACTIVATED"),

    USER_KTP_CANDYPAY_FAIL(101026, "USER.ERR.KTP.007"),//非candypay的合作商户无法进行此申请,请上传已绑定candypay的KTP证件
    BANK_CARD_CANDYPAY_FAIL(101027, "USER.INFO.BANKCARD.007"),//非candypay的合作商户无法进行此申请,请上传已绑定candypay的KTP证件

    //展期
    DEBTDELAY_DAY_ERROR(102001,"DEBTDELAY_DAY_ERROR"),
    DEBTDELAY_NOT_EXIST(102002,"DEBTDELAY_NOT_EXIST"),
    DEBTDELAY_PROCESSING(102003,"DEBTDELAY_PROCESSING"),

    ;

    private Integer code;
    private String value;

    AppErrorCodeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public static String getValue(Integer code) {
        for (AppErrorCodeEnum c : AppErrorCodeEnum.values()) {
            if (c.code.equals(code)) {
                return c.value;
            }
        }
        return null;
    }

    public static AppErrorCodeEnum getEnum(String value) {
        for (AppErrorCodeEnum c : AppErrorCodeEnum.values()) {
            if (c.value.equals(value)) {
                return c;
            }
        }
        return null;
    }
}
