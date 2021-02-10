package com.muse.genericity;

import java.util.Arrays;
import java.util.List;

/**
 * 类型通配符
 */
public class TypeWildcard {

    private final static List<Integer> LIST_INTEGER = Arrays.asList(1, 2, 3, 4);

    private final static List<Object> LIST_OBJECT = Arrays.asList(1, 2, 3, 4);

    private final static List<String> LIST_STRING = Arrays.asList("a", "b", "c", "d");

    public static void main(String[] args) {
        TypeWildcard typeWildcard = new TypeWildcard();
        typeWildcard.test1(LIST_INTEGER);

        // typeWildcard.test2(LIST_INTEGER);
        typeWildcard.test2(LIST_OBJECT);

        typeWildcard.test3(LIST_INTEGER);

        typeWildcard.test4(LIST_INTEGER);

        /**上限通配符*/
        typeWildcard.test5(LIST_INTEGER);
        // typeWildcard.test5(LIST_STRING);

        /**下限通配符*/
    }

    public void test1(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void test2(List<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void test3(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            // list.add(list.get(0)); 编译错误
            System.out.println(list.get(i));
        }
    }

    public <T> void test4(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            // list.add(list.get(0)); 编译阶段ok，但是运行时抛异常，Exception in thread "main" java.lang.UnsupportedOperationException
            System.out.println(list.get(i));
        }
    }

    public void test5(List<? extends Number> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}


