package com.example.unit.test.github.test;

public class CheckVerifyCodeReq extends BaseReq{
    private LoginTypeEnum loginType;
    private BizTypeEnum bizType;
    private String accountName;
    private String verifyCode;

    public CheckVerifyCodeReq() {
    }

    public LoginTypeEnum getLoginType() {
        return this.loginType;
    }

    public BizTypeEnum getBizType() {
        return this.bizType;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    public void setLoginType(final LoginTypeEnum loginType) {
        this.loginType = loginType;
    }

    public void setBizType(final BizTypeEnum bizType) {
        this.bizType = bizType;
    }

    public void setAccountName(final String accountName) {
        this.accountName = accountName;
    }

    public void setVerifyCode(final String verifyCode) {
        this.verifyCode = verifyCode;
    }

}
