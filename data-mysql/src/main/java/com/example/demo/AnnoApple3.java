package com.example.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jason on 18/5/14.
 */
@Target(value = {FIELD, TYPE})
@Retention(RUNTIME)
@Documented
@FruitName("Apple3")
@FruitColor(fruitColor = FruitColor.Color.BLUE)
@FruitProvider(id = 1, name = "山西西红富士集团", address = "山西西省西安市延安路89号红富士大厦")
public @interface AnnoApple3 {
}
