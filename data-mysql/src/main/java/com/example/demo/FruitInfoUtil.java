package com.example.demo;

/**
 * Created by Jason on 18/5/14.
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 注解处理器
 */
public class FruitInfoUtil {

    public static void getFruitFieldInfo(Class<?> clazz) {

        String strFruitName = " 水果名称：";
        String strFruitColor = " 水果颜色：";
        String strFruitProvicer = "供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            System.out.println("field name:" + field.getName());
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvicer = " 供应商编号：" + fruitProvider.id() + " 供应商名称：" + fruitProvider.name() + " 供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvicer);
            }
        }
    }

    public static void getFruitClassInfo(Class<?> clazz) {
        Annotation[] anns = clazz.getDeclaredAnnotations();
        for (Annotation annotation : anns) {

            System.out.println("annation : " + annotation.toString());

            Annotation[] annsOnAnn = annotation.annotationType().getDeclaredAnnotations();

            for (Annotation annOnAnn : annsOnAnn) {
//                注解的注解要单独提取？
                System.out.println("    annation of annation : " + annOnAnn.toString());

            }
        }
    }
}