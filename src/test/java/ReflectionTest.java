import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.muse.reflect.Animal;
import com.muse.reflect.Dog;
import com.muse.reflect.Person;

/*
 * Copyright (C) 2020 Baidu, Inc. All Rights Reserved.
 */
public class ReflectionTest {

    @Test
    public void test() throws Throwable{
        // 方式一  类.class
        Class personClazz = Person.class;

        // 方式二  实例.getClass()
        Person person = new Person();
        Class personClazz1 = person.getClass();

        // 方式三  Class.forName("类的全路径")
        Class personClazz2 = Class.forName("com.muse.reflect.Person");

        System.out.println(personClazz == personClazz1);

        System.out.println(personClazz == personClazz2);

    }

    /**
     * // 无参数
     * <bean id="person" class="com.muse.reflect.Person" />
     *
     * // 有参数
     * <bean id="person" class="com.muse.reflect.Person" >
     *    <constructor-arg index="0" type="java.lang.String" value="muse"/>
     * </bean>
     *
     *
     * @throws Throwable
     */
    @Test
    public void test2() throws Throwable{
        // 第一步：获得Class
        Class personClazz = Person.class;

        // 第二步：获得构造方法
        // Constructor<Person> constructor = personClazz.getConstructor();
        // String name, Integer age, Byte sex, Boolean isMarriage
        Constructor<Person> constructor = personClazz.getConstructor(String.class, Integer.class, Byte.class,
                Boolean.class);

        // 第三步：创建对象 new Person(String name, Integer age, Byte sex, Boolean isMarriage)
        Person person = constructor.newInstance("muse", 10, (byte)1, true);

        // person.setName("muse");

        ;

    }

    /**
     * public属性的
     *
     * @throws Throwable
     */
    @Test
    public void test3() throws Throwable{
        // 第一步：获得Class
        Class personClazz = Person.class;

        // 第二步：获得构造方法
        Constructor<Person> constructor = personClazz.getConstructor();
        Person person = constructor.newInstance();

        // 第三步：通过Class对象，获得Field对象
        Field nameField = personClazz.getField("name");

        // 第四步：操作Field，获得属性值
        String name = String.valueOf(nameField.get(person));

        System.out.println(name);
    }

    /**
     * private
     *
     * @throws Throwable
     */
    @Test
    public void test4() throws Throwable{
        // 第一步：获得Class
        Class personClazz = Person.class;

        // 第二步：获得构造方法
        Constructor<Person> constructor = personClazz.getConstructor();
        Person person = constructor.newInstance();

        // 第三步：通过Class对象，获得Field对象
        Field sexField = personClazz.getDeclaredField("sex");
        sexField.setAccessible(true);

        // 第四步：操作Field，获得属性值
        System.out.println(sexField.get(person));
    }

    /**
     * 去读，不去写
     */
    @Test
    public void testPECSExtends() {
        List<Dog> dogs = Lists.newArrayList();
        dogs.add(new Dog());

        // 只知道animals里保存的是Animal的子类
        List<? extends Animal> animals = dogs;

        // animals.add(new Dog()); // 编译失败
        // animals.add(new Animal()); // 编译失败

        Animal animal = animals.get(0);
        // Dog dog = animals.get(0); // 编译失败

    }


}
