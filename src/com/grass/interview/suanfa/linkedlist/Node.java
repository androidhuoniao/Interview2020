package com.grass.interview.suanfa.linkedlist;

public class Node {
    public String data;
    public Node next;

    Node(String data) {
        this.data = data;
    }

    public int getIntdata() {
        return Integer.parseInt(data);
    }
    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", next=" + (next != null ? next.data : "tail") +
                '}';
    }
}
