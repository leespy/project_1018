/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.muse.reflect;

/**
 * @author muse
 */
public class Person1 {

    public String name;

    protected Integer age;

    private Byte sex;

    Boolean isMarriage1;

    public Person1() {
    }

    public Person1(String name, Integer age, Byte sex, Boolean isMarriage1) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.isMarriage1 = isMarriage1;
    }

    public Boolean getMarriage1() {
        return isMarriage1;
    }

    public void setMarriage1(Boolean marriage1) {
        isMarriage1 = marriage1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", isMarriage1=" + isMarriage1 +
                '}';
    }
}
