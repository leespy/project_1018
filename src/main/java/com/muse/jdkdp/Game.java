/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
package com.muse.jdkdp;

/**
 * JDK Dynamic Proxy
 * Date 2020/10/24 10:42 上午
 * @author muse
 */
public interface Game {

    String value = "aa";

    String play();

    default void foo() {

        System.out.println("InterfaceA foo");
    }
}
