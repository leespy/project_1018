package com.muse.genericity;

import java.util.List;

import com.google.common.collect.Lists;
import com.muse.reflect.Animal;
import com.muse.reflect.Cat;
import com.muse.reflect.Dog;
import com.muse.reflect.WhiteDog;

/**
 * PECS(Producer Extends Consumer Super)
 *
 * https://www.cnblogs.com/huoqm/p/13931363.html
 * https://www.cnblogs.com/zhaoyibing/p/9051428.html
 */
public class Pecs {

    public static void main(String[] args) {
        testPECSextends();
        testPECSsuper();
    }

    /**
     * 【读取】
     * 如果要从集合中【可读取】类型T的数据，并且【不能写入】，可以使用 ? extends 通配符；(Producer Extends)
     * List<? extends Animal> animals 里面能够存放什么呢？
     * 动物、狗、猫、猪、鸡... 只要是动物，都有可能被存入进animals里。
     */
    public static void testPECSextends() {
        List<Dog> dogs = Lists.newArrayList(new Dog());
        List<? extends Animal> animals = dogs;

        /**
         * animals是一个Animal的子类的List,由于Dog是Animal的子类，因此将dogs赋给animals是合法的，但是编译器会阻止将new Cat()加入animals。
         * 因为编译器只知道animals是Animal的某个子类的List，但并不知道究竟是哪个子类，为了类型安全，只好阻止向其中加入任何子类。那么可不可以加入
         * new Animal()呢？很遗憾，也不可以。事实上，不能够往一个使用了? extends的数据结构里写入任何的值。
         */
        // animals.add(new Cat()); // 编译失败
        // animals.add(new Animal()); // 编译失败
        // animals.add(new Dog()); // 编译失败

        /**
         * 由于编译器知道它总是Animal的子类型，但并不知道具体是哪个子类。因此我们总可以从中读取出Animal对象：
         */
        Animal animal = animals.get(0);
        Object obj = animals.get(0);
        // Dog dog = animals.get(0); // 编译失败
    }

    /**
     * 【写入】
     * 如果要从集合中写入类型T的数据，并且不需要读取，可以使用 ? super 通配符；(Consumer Super)
     * <p>
     * 如果既要存又要取，那么就不要使用任何通配符。
     *
     */
    public static void testPECSsuper() {
        List<Animal> animals = Lists.newArrayList();
        List<? super Dog> dogs = animals;
        /**
         * 这里的animals是一个Animal的超类（父类,superclass）的List。同样地，出于对类型安全的考虑，我们可以加入Dog对象或者其任何子类（如WhiteDog）对象，
         * 但由于编译器并不知道List的内容究竟是Dog的哪个超类，因此不允许加入特定的任何超类型。
         */
        dogs.add(new Dog());
        dogs.add(new WhiteDog());
        // dogs.add(new Animal()); // 编译失败
        // dogs.add(new Cat()); // 编译失败
        // dogs.add(new Object()); // 编译失败

        /**
         * 而当我们读取的时候，编译器在不知道是什么类型的情况下只能返回Object对象，因为Object是任何Java类的最终祖先类。
         */
        Object obj = dogs.get(0);
        // Dog dog = dogs.get(0); // 编译失败
        // Animal animal = dogs.get(0); // 编译失败
    }
}
