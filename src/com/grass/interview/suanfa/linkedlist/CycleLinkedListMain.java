package com.grass.interview.suanfa.linkedlist;

public class CycleLinkedListMain {

    public static void main(String[] args) {
        Node cycleLinkedList = LinkedListFactory.getCycleLinkedList();
        boolean isCycle = detectCycleLinkedList(cycleLinkedList);
        int count = computeCycleCount(cycleLinkedList);
        System.out.println("isCycle: " + isCycle + " CycleCount: " + count);
        Node linkedNode = getLinkedNode(cycleLinkedList);
        System.out.println("linedNode: " + linkedNode);
    }

    /**
     * 检查链表有环
     * 1. 仅需要判断fastNode不为null就可以了，因为fastNode更快一步啊
     *
     * @return
     */
    public static boolean detectCycleLinkedList(Node headNode) {
        boolean isCycle = false;
        Node slowNode = headNode;
        Node fastNode = headNode;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                isCycle = true;
                break;
            }
        }
        return isCycle;
    }

    /**
     * get the cycle point node
     *
     * @param headNode
     * @return
     */
    public static Node getLinkedNode(Node headNode) {
        Node fastNode = headNode;
        Node slowNode = headNode;
        Node linkedNode = null;
        boolean isCycle = false;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            return linkedNode;
        }
        slowNode = headNode;
        while (true) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (slowNode == fastNode) {
                linkedNode = slowNode;
                break;
            }
        }
        return linkedNode;
    }

    /**
     * 计算环的长度
     *
     * @param headNode
     * @return
     */
    public static int computeCycleCount(Node headNode) {
        int count = 0;
        Node fastNode = headNode;
        Node slowNode = headNode;
        boolean isCycle = false;

        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                isCycle = true;
                break;
            }
        }
        if (!isCycle) {
            return count;
        }
        slowNode = headNode;
        while (slowNode != fastNode) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        Node linkedNode = slowNode;
        Node startNode = slowNode;
        while (linkedNode != startNode.next) {
            count++;
            startNode = startNode.next;
        }
        return count;
    }
}
