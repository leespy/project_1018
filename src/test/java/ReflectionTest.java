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
        /** 首先：获得Person的字节码 */
        Class personClazz = Class.forName("com.muse.reflect.Person");

        /** 其次：通过Class对象，创建构造方法对象 */
        Constructor constructor1 = personClazz.getConstructor(); // 初始化无参构造方法
        Constructor constructor2 = personClazz.getConstructor(String.class, Integer.class, Byte.class,
                Boolean.class); // 初始化有参构造方法对象

        /** 最后：通过构造方法创建对象 */
        // 调用无参数构造方法创建Person对象
        Person person1 = (Person) constructor1.newInstance();
        person1.setName("muse1");
        System.out.println("person1=" + person1);

        // 调用有参数构造方法创建Person对象
        Person person2 = (Person) constructor2.newInstance("muse2", 10, (byte) 1, true);
        System.out.println("person2=" + person2);
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
        // sexField.setAccessible(true);

        // 第四步：操作Field，获得属性值
        System.out.println(sexField.get(person));
    }

    /**
     * 通过反射获得类的public属性值
     * <p>
     * getField 只能获取public的，包括从父类继承来的字段。
     * getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。 (注： 这里只能获取到private的字段，但并不能访问该private字段的值,
     * 除非加上setAccessible(true))
     */
    @Test
    public void getPublicField() throws Throwable {
        /** 首先：获得Person的字节码 */
        Class personClazz = Person.class;

        /** 其次：获得Person对象（由于非静态非private的属性，访问使用 对象.属性方式访问，所以反射必须先获得对象实例）*/
        Person person = (Person) personClazz.getConstructor().newInstance();

        /** 第三：通过Class对象，获得Field对象 */
        Field nameField = personClazz.getDeclaredField("name");
        // Field nameField = personClazz.getField("name");

        /**
         * Field.toString();
         * --------------------------------------------------------------------
         * public String toString() {
         *         int mod = getModifiers();
         *         return (((mod == 0) ? "" : (Modifier.toString(mod) + " "))
         *             + getType().getTypeName() + " "
         *             + getDeclaringClass().getTypeName() + "."
         *             + getName());
         * }
         *
         * 【Field的重要方法】
         * System.out.println("获取字段的类型:" + nameField.getType());
         * System.out.println("获取字段的名字:" + nameField.getName());
         * System.out.println("获取字段的访问修饰符:" + Modifier.toString(nameField.getModifiers()));
         * System.out.println("获取字段所在类的全路径:" + nameField.getDeclaringClass().getName());
         */
        System.out.println(nameField); // protected java.lang.Integer com.muse.Person.name

        /** 最后：获取字段的类型 */
        String name = String.valueOf(nameField.get(person));
        System.out.println(name);
    }

    /**
     * 获得private属性
     *
     * @throws Throwable
     */
    @Test
    public void getPrivateField() throws Throwable {
        /** 首先：获得Person的字节码 */
        Class personClazz = Person.class;

        /** 其次：获得Person对象（由于非静态非private的属性，访问使用 对象.属性方式访问，所以反射必须先获得对象实例）*/
        Person person = (Person) personClazz.getConstructor().newInstance();

        /** 第三：通过Class对象，获得Field对象 */
        // Field sexField = personClazz.getField("sex");  // 不能使用getField，否则报错：java.lang.NoSuchFieldException: sex
        Field sexField = personClazz.getDeclaredField("sex");
        // sexField.setAccessible(true); // 必须设置为true

        /** 最后：获取字段的类型 */
        Byte sex = (Byte) sexField.get(person);
        System.out.println(sex);
    }

    /**
     * 获得protected属性
     *
     * @throws Throwable
     */
    @Test
    public void getProtectedField() throws Throwable {
        /** 首先：获得Person的字节码 */
        Class personClazz = Person.class;

        /** 其次：获得Person对象（由于非静态非private的属性，访问使用 对象.属性方式访问，所以反射必须先获得对象实例）*/
        Person person = (Person) personClazz.getConstructor().newInstance();

        /** 第三：通过Class对象，获得Field对象 */
        Field ageField = personClazz.getDeclaredField("age");
        // ageField.setAccessible(true); // 必须设置为true，如果不设置，则报错：java.lang.IllegalAccessException: Class ReflectionTest can not access a member of class com.muse.Person with modifiers "protected"

        /** 最后：获取字段的类型 */
        Integer age = (Integer) ageField.get(person);
        System.out.println(age);
    }

    /**
     * 获得default属性
     *
     * @throws Throwable
     */
    @Test
    public void getDefaultField() throws Throwable {
        /** 首先：获得Person的字节码 */
        Class personClazz = Person.class;

        /** 其次：获得Person对象（由于非静态非private的属性，访问使用 对象.属性方式访问，所以反射必须先获得对象实例）*/
        Person person = (Person) personClazz.getConstructor().newInstance();

        /** 第三：通过Class对象，获得Field对象 */
        Field isMarriageField = personClazz.getDeclaredField("isMarriage");
        // isMarriageField.setAccessible(true); // 必须设置为true，如果不设置，则报错：java.lang.IllegalAccessException: Class ReflectionTest can not access a member of class com.muse.Person with modifiers ""

        /** 最后：获取字段的类型 */
        Boolean isMarriage = (Boolean) isMarriageField.get(person);
        System.out.println(isMarriage);
    }


}
