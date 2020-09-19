package com.grass.interview.suanfa.linkedlist;

/**
 * [图解：单链表删除，不遍历链表也能做（时间复杂度O\(1\)） · 语雀](https://www.yuque.com/wangshengwei-evzp3/te8s4z/pnp4eu)
 */
public class DeleteLinkedList {
    public static void main(String[] args) {
        Node linkedList = LinkedListFactory.getNormalLinkedList();
        linkedList = deleteNode(linkedList, NodeUtils.findIndexNode(linkedList, 4));
        NodeUtils.logNormalLinkedList(linkedList);
    }

    private static Node deleteNode(Node linkedList, Node deletNode) {
        if (deletNode == null) {
            return linkedList;
        }
        if (deletNode.next != null) {
            Node nextNode = deletNode.next;
            deletNode.data = nextNode.data;
            deletNode.next = nextNode.next;
            nextNode.next = null;
        }
        return linkedList;
    }
}
