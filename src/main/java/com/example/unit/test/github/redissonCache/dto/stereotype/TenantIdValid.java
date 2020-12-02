package com.example.unit.test.github.redissonCache.dto.stereotype;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: dupan
 **/
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {TenantIdValidator.class})
public @interface TenantIdValid {
    String message() default "自定义检查tenantId注解";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}