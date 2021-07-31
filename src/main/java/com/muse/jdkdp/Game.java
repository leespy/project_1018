/*
 */
package com.muse.jdkdp;

/**
 * JDK Dynamic Proxy
 * @author muse
 */
public interface Game {

    String value = "aa";

    String play();

    default void foo() {

        System.out.println("InterfaceA foo");
    }
}
