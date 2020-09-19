package com.grass.interview.suanfa.linkedlist;

public class NodeUtils {
    public static Node findTailNode(Node headNode) {
        Node tailNode = null;
        if (headNode != null) {
            while (headNode.next != null) {
                tailNode = headNode.next;
                headNode = tailNode;
            }
        }
        return tailNode;
    }


    public static Node findIndexNode(Node headNode, int index) {
        Node indexNode = null;
        if (headNode != null) {
            int count = 0;
            while (headNode.next != null) {
                count++;
                indexNode = headNode.next;
                headNode = indexNode;
                if (count == index) {
                    return indexNode;
                }
            }
        }
        return indexNode;
    }

    public static void logNormalLinkedList(Node headNode) {
        if (headNode == null || headNode.next == null) {
            System.out.println("headNode is null or only one node");
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(headNode.data).append(" , ");
        while (headNode.next != null) {
            Node temp = headNode.next;
            sb.append(temp.data).append(" , ");
            headNode = temp;
        }
        System.out.println("logNormalLinkedList: " + sb.toString());
    }
}
