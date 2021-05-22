/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.muse.reflect;

/**
 * @author muse
 */
public interface Inter<T> {

    void show(T t);
}

/** 子类明确类型*/
class InterImpl implements Inter<String> {

    @Override
    public void show(String s) {

    }
}

/** 子类不明确类型*/
class InterImpl1<T> implements Inter<T> {

    @Override
    public void show(T o) {

    }
}
