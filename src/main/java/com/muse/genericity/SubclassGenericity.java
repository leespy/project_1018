package com.muse.genericity;

/**
 * 泛型类派生出的子类
 *
 * @author muse
 */
public class SubclassGenericity {
    public static void main(String[] args) {
        // 测试第一种情况
        Inter<String> i = new InterImpl1();
        i.show("hello");

        // 编译错误
        //        Inter<Integer> ii = new InterImpl1();
        //        ii.show(1);

        // 第二种情况测试
        Inter<String> iii = new InterImpl2();
        iii.show("100");

    }
}

/**
 * 把泛型定义在接口上
 */
interface Inter<T> {
    void show(T t);
}

/**
 * 子类明确泛型类的类型参数变量
 */
class InterImpl1 implements Inter<String> {
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}

/**
 * 子类不明确泛型类的类型参数变量，实现类也要定义出T的类型
 */
class InterImpl2<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}