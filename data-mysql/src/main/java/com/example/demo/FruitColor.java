package com.example.demo;

/**
 * Created by Jason on 18/5/14.
 */

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 水果颜色注解
 */
@Target(value = {FIELD, TYPE})
@Retention(RUNTIME)
@Documented
public @interface FruitColor {
    /**
     * 颜色枚举
     */
    public enum Color {
        BLUE, RED, GREEN
    }

    ;

    /**
     * 颜色属性
     */
    Color fruitColor() default Color.GREEN;

}
