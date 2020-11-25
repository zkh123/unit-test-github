package com.example.unit.test.github.test;

import java.util.HashMap;
import java.util.Map;

public enum LoginTypeEnum {
    Mobile(1),
    Email(2),
    Facebook(3),
    Google(4);

    private int code;
    private static Map<Integer, LoginTypeEnum> codeMap = new HashMap();

    private LoginTypeEnum(int code) {
        this.code = code;
    }

    public static LoginTypeEnum getByCode(int code) {
        return (LoginTypeEnum)codeMap.get(code);
    }

    public int getCode() {
        return this.code;
    }

    static {
        codeMap.put(Mobile.getCode(), Mobile);
        codeMap.put(Email.getCode(), Email);
        codeMap.put(Facebook.getCode(), Facebook);
        codeMap.put(Google.getCode(), Google);
    }
}
