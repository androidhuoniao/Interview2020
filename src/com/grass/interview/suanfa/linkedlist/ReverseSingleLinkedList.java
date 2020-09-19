package com.grass.interview.suanfa.linkedlist;

/**
 * 单链表反转
 * 1-->2-->3-->4
 * 4-->3-->2-->1
 * [图解：单链表反转的三种方式！ · 语雀](https://www.yuque.com/wangshengwei-evzp3/te8s4z/ivtwsn)
 */
public class ReverseSingleLinkedList {
    public static void main(String[] args) {
        Node linkedList = LinkedListFactory.getNormalLinkedList();
        Node node = reverseByLoop(linkedList);
        NodeUtils.logNormalLinkedList(node);
        Node node1 = reverseSingleLinkedList(LinkedListFactory.getNormalLinkedList());
        NodeUtils.logNormalLinkedList(node1);
    }

    public static Node reverseSingleLinkedList(Node headNode) {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }
        Node prevNode = null;
        Node nextNode = null;
        while (headNode != null) {
            nextNode = headNode.next;
            headNode.next = prevNode;
            prevNode = headNode;
            headNode = nextNode;
        }
        // 这里返回的prevNode，为什么呢，因为headNode==null的时候才能退出循环，所以返回prev
        return prevNode;
    }

    static Node reverseByLoop(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node preNode = null;
        Node nextNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }
}
