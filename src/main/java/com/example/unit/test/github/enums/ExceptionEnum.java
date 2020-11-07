package com.example.unit.test.github.enums;

import lombok.Getter;

/**
 * 自定义异常的各种类型
 */
@Getter
public enum ExceptionEnum {
    SYSTEM_ERROR("001"),
    NOT_QUALIFIED("998", ""),
    NO_REMAIN_COUNT("999", ""),
    SEND_REPEAT("007", "重复发送");

    private String code;  //异常代码
    private String errorMsg; //异常描述

    ExceptionEnum(String code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    ExceptionEnum(String code) {
        this.code = code;
    }
}
