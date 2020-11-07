package com.example.unit.test.github.exception;

import com.example.unit.test.github.enums.ExceptionEnum;
import lombok.Getter;

/**
 * 自定义 运行时异常
 */
@Getter
public class ExceptionCatch extends RuntimeException {
    private final ExceptionEnum exceptionEnum;

    public ExceptionCatch(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
}
