package com.example.unit.test.github.test;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
@LenderBlock
public @interface LoginContext {
    boolean required() default true;

    boolean isAjax() default true;
}