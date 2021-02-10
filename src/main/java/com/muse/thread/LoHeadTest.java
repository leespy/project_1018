package com.muse.thread;

public class LoHeadTest {

    public static void main(String[] args) {
        Node node1 = new Node("a");

        Node head = node1;
        Node tail = node1;
        System.out.println("head = " + head);
        System.out.println("tail = " + tail);
        System.out.println("---------------------");
        tail.setValue("b");
        Node node2 = new Node("b");
        tail = node2;
        System.out.println("head = " + head);
        System.out.println("tail = " + tail);
    }

}

class Node {

    private String value;

    public Node() {
    }

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
    }
}