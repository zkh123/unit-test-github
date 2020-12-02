package com.example.unit.test.github.redissonCache.dto.stereotype;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册/登录方式枚举
 *
 */
@Getter
public enum LoginTypeEnum {

    /**
     * 手机
     */
    Mobile(1),
    /**
     * 邮箱
     */
    Email(2),
    /**
     * Facebook
     */
    Facebook(3),
    /**
     * Google
     */
    Google(4),
    ;

    private int code;

    LoginTypeEnum(int code) {
        this.code = code;
    }

    private static Map<Integer, LoginTypeEnum> codeMap = new HashMap<>();

    static {
        codeMap.put(Mobile.getCode(), Mobile);
        codeMap.put(Email.getCode(), Email);
        codeMap.put(Facebook.getCode(), Facebook);
        codeMap.put(Google.getCode(), Google);

    }

    public static LoginTypeEnum getByCode(int code) {
        return codeMap.get(code);
    }
}
