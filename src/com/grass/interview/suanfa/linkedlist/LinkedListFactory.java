package com.grass.interview.suanfa.linkedlist;

public class LinkedListFactory {

    public static Node getNormalLinkedList() {
        Node headNode = new Node("0");
        Node preNode = headNode;
        for (int i = 1; i < 10; i++) {
            Node nextNode = new Node(String.valueOf(i));
            preNode.next = nextNode;
            preNode = nextNode;
        }
//        System.out.println("getNormalLinkedList(): " + headNode);
        return headNode;
    }


    public static Node getCycleLinkedList() {
        Node headNode = getNormalLinkedList();
        Node tailNode = NodeUtils.findTailNode(headNode);
        Node indexNode = NodeUtils.findIndexNode(headNode, 5);
        System.out.println("tailNode: " + tailNode + " 5.node: " + indexNode);
        tailNode.next = indexNode;
        return headNode;
    }

}
