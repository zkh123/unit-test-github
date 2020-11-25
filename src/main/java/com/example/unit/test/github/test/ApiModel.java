package com.example.unit.test.github.test;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ApiModel {
    String value() default "";

    String description() default "";

    Class<?> parent() default Void.class;

    String discriminator() default "";

    Class<?>[] subTypes() default {};
}