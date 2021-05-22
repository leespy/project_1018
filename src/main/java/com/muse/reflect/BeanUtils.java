/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.muse.reflect;

import java.lang.reflect.Field;

/**
 * @author muse
 */
public class BeanUtils {

    public static void convertor(Object originObj, Object targetObj) throws Throwable{
        // 第一步，获得class对象
        Class orginClazz = originObj.getClass();
        Class targetClazz = targetObj.getClass();

        // 第二步，获得Field
        Field[] orginFields =  orginClazz.getDeclaredFields();
        Field[] targetFields =  targetClazz.getDeclaredFields();

        // 第三步：赋值
        for (Field originField : orginFields) {
            for (Field targetField : targetFields) {
                if (originField.getName().equals(targetField.getName())) {
                    originField.setAccessible(true);
                    targetField.setAccessible(true);
                    targetField.set(targetObj, originField.get(originObj));
                }
            }
        }
    }

    public static void main(String[] args) throws Throwable{
        // Service层返回的
        Person person = new Person("muse", 10, (byte)1, true);

        // 需要返回实体对象
        Person1 person1 = new Person1();

        BeanUtils.convertor(person, person1);

        System.out.println("person" + person);

        System.out.println("person1" + person1);

    }
}


