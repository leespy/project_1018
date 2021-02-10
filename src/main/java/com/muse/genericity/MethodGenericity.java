/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.muse.genericity;

/**
 * 泛型方法
 *
 * @author muse
 */
public class MethodGenericity<T> {
    public static void main(String[] args) {
        //创建对象
        ObjectTool tool = new ObjectTool();
        //调用方法,传入的参数是什么类型,返回值就是什么类型
        tool.show("hello");
        tool.show(12);
        tool.show(12.5);
    }

    static class ObjectTool {
        //定义泛型方法..
        public <T> void show(T t) {
            System.out.println(t);
        }
    }
}

