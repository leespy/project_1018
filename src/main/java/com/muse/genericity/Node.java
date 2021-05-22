package com.muse.genericity;

/**
 * 桥接方法
 * 1> 类型擦除 javac ——> class 泛型被擦除了！
 * 2> 泛型虽然被擦除了，但是，你一定要给我保留泛型的行为！
 * @param <T>
 */
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

    public void setData(Integer data) {
        super.setData(data);
    }

    @Override
    public void setData(Object data) {
        setData((Integer) data);
    }
}
