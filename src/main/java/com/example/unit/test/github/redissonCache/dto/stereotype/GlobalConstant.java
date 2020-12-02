package com.example.unit.test.github.redissonCache.dto.stereotype;

import java.util.HashSet;
import java.util.Set;

/**
 * The class Global constant.
 *
 */
public class GlobalConstant {

    /**
     * 校验参数相关错误代码
     */
    public static final class CheckErrCode {

        /**
         * tenantId不能为空
         */
        public static final String CHECK_ERR_CODE_TENANTID_NO_NULL = "CHECK_ERR_CODE.TENANTID.NO_NULL";


        /**
         * 账号不能为空
         */
        public static final String CHECK_ERR_CODE_ACCOUNT_NO_NULL = "CHECK_ERR_CODE.ACCOUNT.NO_NULL";

        /**
         * 登录方式不能为空
         */
        public static final String CHECK_ERR_CODE_LOGINTYPE_NO_NULL = "CHECK_ERR_CODE.LOGINTYPE.NO_NULL";

        /**
         * 密码不能为空
         */
        public static final String CHECK_ERR_CODE_PASSWORD_NO_NULL = "CHECK_ERR_CODE.PASSWORD.NO_NULL";

        /**
         * 验证码不能为空
         */
        public static final String CHECK_ERR_CODE_VERIFYCODE_NO_NULL = "CHECK_ERR_CODE.VERIFYCODE.NO_NULL";

        /**
         * token不能为空
         */
        public static final String CHECK_ERR_CODE_TOKEN_NO_NULL = "CHECK_ERR_CODE.TOKEN.NO_NULL";

        /**
         * 手机号不能为空
         */
        public static final String CHECK_ERR_CODE_MOBILE_NO_NULL = "CHECK_ERR_CODE.MOBILE.NO_NULL";

        /**
         * 手机号不能为空
         */
        public static final String CHECK_ERR_CODE_MSGTYPE_NO_NULL = "CHECK_ERR_CODE.MSGTYPE.NO_NULL";

        /**
         * LOCALE不能为空
         */
        public static final String CHECK_ERR_CODE_LOCALE_NO_NULL = "CHECK_ERR_CODE.LOCALE.NO_NULL";

        /**
         * email不能为空
         */
        public static final String CHECK_ERR_CODE_EMAIL_NO_NULL = "CHECK_ERR_CODE.EMAIL.NO_NULL";

        /**
         * userId不能为空
         */
        public static final String CHECK_ERR_CODE_USERID_NO_NULL = "CHECK_ERR_CODE.USERID.NO_NULL";
    }

    /**
     * tenant相关信息 tenantId
     */
    public static Set<Long> tenants = new HashSet<>();


}
