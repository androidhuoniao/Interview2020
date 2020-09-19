package com.grass.interview.suanfa.linkedlist;

import java.util.ArrayList;

/**
 * Created by grassswwang
 * on 2020/9/19
 * Email: grassswwang@tencent.com
 */
public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(String.valueOf("1"));
        list1.add(String.valueOf("2"));
        list1.add(String.valueOf("4"));
        Node linkedList1 = LinkedListFactory.getLinekedList(list1);
        NodeUtils.logNormalLinkedList(linkedList1);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add(String.valueOf("1"));
        list2.add(String.valueOf("3"));
        list2.add(String.valueOf("4"));
        list2.add(String.valueOf("5"));
        Node linkedList2 = LinkedListFactory.getLinekedList(list2);
        NodeUtils.logNormalLinkedList(linkedList2);

//        Node mergedList = mergeTwoLists(linkedList1, linkedList2);
//        NodeUtils.logNormalLinkedList(mergedList);

//        NodeUtils.logNormalLinkedList(mergeTwoLists2(linkedList1, linkedList2));

        NodeUtils.logNormalLinkedList(mergedLinkedList(linkedList1, linkedList2));

    }

    public static Node mergedLinkedList(Node l1, Node l2) {
        Node headNode = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Node preNode = new Node("-1");
        headNode = preNode;
        while (l1 != null && l2 != null) {
            if (l1.getIntdata() < l2.getIntdata()) {
                preNode.next = l1;
                preNode = l1;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                preNode = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null && l2 != null) {
            preNode.next = l2;
        }

        if (l1 != null && l2 == null) {
            preNode.next = l1;
        }
        return headNode.next;
    }

    public static Node mergeTwoLists(Node l1, Node l2) {
        //如果 l1 或者 l2 一开始就是 null ，说明不需要合并，所以我们只需要返回非空链表
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //如果11的val值更小，则将11.next与排序好的链表头相接，12同理
        if (l1.getIntdata() < l2.getIntdata()) {
            l1.next = mergeTwoLists(l1.next, l2);
            //每一层调用都返回排序好的链表头
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static Node mergeTwoLists2(Node l1, Node l2) {
        //先初始化一个预先指针 prehead，该指针的下一个节点指向真正的头结点head，是用来定位头结点的
        Node prehead = new Node("-1");
        Node prev = prehead;
        //遍历列表l1和l2，直到全部遍历完毕
        while (l1 != null && l2 != null) {
            if (l1.getIntdata() <= l2.getIntdata()) {
                //prev.next始终指向比较之后的那个小的，l2同理
                prev.next = l1;
                //当前位置的l1后移一位
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        //在循环终止的时候， l1 和 l2 至多有一个是非空的。
        //需要将非空链表接在合并链表的后面，并返回合并链表。
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
