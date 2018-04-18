package com.example.demo;

import java.lang.annotation.*;

/**
 * Created by Jason on 18/4/16.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "jjjjj";

    String date();

    int revisoion() default 1;

    String comments();
}
