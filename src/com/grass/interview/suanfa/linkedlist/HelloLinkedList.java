package com.grass.interview.suanfa.linkedlist;

public class HelloLinkedList {

    public static void main(String[] args) {
        Node normalLinkedList = LinkedListFactory.getNormalLinkedList();
        NodeUtils.logNormalLinkedList(normalLinkedList);
        Node cycleLinkedList = LinkedListFactory.getCycleLinkedList();
        NodeUtils.logNormalLinkedList(cycleLinkedList);

    }
}
