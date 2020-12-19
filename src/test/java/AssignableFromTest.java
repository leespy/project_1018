/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */

import org.junit.Test;

import com.muse.reflect.Animal;
import com.muse.reflect.Dog;
import com.muse.reflect.EveryThing;

/**
 * Date 2020/10/14 10:11 上午
 * Author muse
 */
public class AssignableFromTest {

    /**
     * isAssignableFrom()方法与instanceof关键字的区别总结为以下两个点：
     *
     * isAssignableFrom()方法是从类继承的角度去判断，instanceof关键字是从实例继承的角度去判断。
     * isAssignableFrom()方法是判断是否为某个类的父类，instanceof关键字是判断是否某个类的子类。
     * 使用方法：
     *      父类.class.isAssignableFrom(子类.class)
     *      子类实例 instanceof 父类类型
     * isAssignableFrom()方法的调用者和参数都是Class对象，调用者为父类，参数为本身或者其子类。
     * instanceof关键字两个参数，前一个为类的实例，后一个为其本身或者父类的类型。
     */
    @Test
    public void test() {
        Animal animal = new Animal();
        Dog dog = new Dog();

        /** 类 */
        System.out.println("Dog.class.isAssignableFrom(Animal.class) = " + Dog.class.isAssignableFrom(Animal.class));
        System.out.println("Animal.class.isAssignableFrom(Dog.class) = " + Animal.class.isAssignableFrom(Dog.class));
        System.out.println("animal instanceof Animal = " + (animal instanceof Animal));
        System.out.println("dog instanceof Animal = " + (dog instanceof Animal));
        System.out.println("animal instanceof Dog = " + (animal instanceof Dog));
        System.out.println("dog instanceof Dog = " + (dog instanceof Dog));

        System.out.println("------------------------------------------------");

        /** 接口 */
        System.out.println("EveryThing.class.isAssignableFrom(Animal.class) = " + EveryThing.class.isAssignableFrom(Animal.class));
        System.out.println("Animal.class.isAssignableFrom(EveryThing.class) = " + Animal.class.isAssignableFrom(EveryThing.class));
        System.out.println("animal instanceof EveryThing = " + (animal instanceof EveryThing));

    }
}
