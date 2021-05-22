package com.muse.genericity;

/**
 * 桥接方法
 * 1> 类型擦除 javac ——> class 泛型被擦除了！
 * 2> 泛型虽然被擦除了，但是，你一定要给我保留泛型的行为！
 *
 * @param <T>
 */

/** 泛型类 */
// public class Node<T> {
//
//     public T data;
//
//     public void setData(T data) {
//         this.data = data;
//     }
// }
//
// class MyNode extends Node<Integer> {
//
//     public Integer data;
//
//     public void setData(Integer data) {
//         this.data = data;
//     }
// }

/** 被擦出后的泛型类 */

public class Node {

    public Object data;

    public void setData(Object data) {

        this.data = data;
    }
}

/**
 * 桥接方法
 */
class MyNode extends Node {

    // 然后内部调用桥接方法，用于对入参类型的限制
    public void setData(Integer data) {

        super.setData(data);
    }

    // 首先请求该方法
    @Override
    public void setData(Object data) {

        setData((Integer) data);
    }
}
