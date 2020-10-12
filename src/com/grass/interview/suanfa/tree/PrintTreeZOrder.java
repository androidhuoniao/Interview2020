package com.grass.interview.suanfa.tree;

import com.grass.interview.utils.LogUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 以z order的形式来遍历一棵树
 */
public class PrintTreeZOrder {
    private static void printZOrder(BinaryNode root) {
        ArrayList<BinaryNode> list = new ArrayList<>();
        Stack<BinaryNode> jishustack = new Stack<>();
        Stack<BinaryNode> oushustack = new Stack<>();
        jishustack.add(root);
        while (!jishustack.isEmpty() || !oushustack.isEmpty()) {
            if (!jishustack.isEmpty()) {
                while (!jishustack.isEmpty()) {
                    BinaryNode node = jishustack.pop();
                    list.add(node);
                    if (node.left != null) {
                        oushustack.add(node.left);
                    }
                    if (node.right != null) {
                        oushustack.add(node.right);
                    }
                }
            } else {
                while (!oushustack.isEmpty()) {
                    BinaryNode node = oushustack.pop();
                    list.add(node);
                    if (node.right != null) {
                        jishustack.add(node.right);
                    }
                    if (node.left != null) {
                        jishustack.add(node.left);
                    }
                }
            }
        }
        System.out.println("printZOrder: " + LogUtils.getLogStr(list));
    }
}
