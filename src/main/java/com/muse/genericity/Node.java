package com.muse.genericity;

/**
 * 桥接方法
 * @param <T>
 */
public class Node<T> {
    public T data;
    public void setData(T data) {
        this.data = data;
    }
}

class MyNode extends Node<Integer> {
    @Override
    public void setData(Integer data) {
    }
}
