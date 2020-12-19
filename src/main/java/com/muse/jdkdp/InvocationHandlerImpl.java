/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.muse.jdkdp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Date 2020/10/24 10:47 上午
 * Author lijinlong02@baidu.com
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object obj;

    public InvocationHandlerImpl(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------------preExecutor-----------------");

        System.out.println("method = " + method);
        Object retValue = method.invoke(obj, args);

        System.out.println("-----------------afterExecutor-----------------");

        return retValue;
    }
}
