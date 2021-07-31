/*
 */
package com.muse.jdkdp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author muse
 */
public class JDKSPTest {

    public static void main(String[] args) {
        SwitchGame switchGame = new SwitchGame();
        InvocationHandler handler = new InvocationHandlerImpl(switchGame);

        Game switchGameProxy = (Game) Proxy.newProxyInstance(switchGame.getClass().getClassLoader(),
                switchGame.getClass().getInterfaces(), handler);

        System.out.println("动态代理对象的类型=" + switchGameProxy.getClass().getName());

        System.out.println("switchGameProxy.play()=" + switchGameProxy.play());
    }
}
