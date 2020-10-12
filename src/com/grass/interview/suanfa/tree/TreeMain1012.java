package com.grass.interview.suanfa.tree;

import com.grass.interview.utils.LogUtils;
import com.grass.interview.utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class TreeMain1012 {
    public static void main(String[] args) {
        int[] array = {8, 3, 5, 20, 15, 2, 29, 1, 4, 6, 13, 16, 21, 30};
        BinaryNode root = new BinaryNode(0);
        BinaryTreeUtils.createBinaryTree(root, array);
        BinaryNode root2 = new BinaryNode(0);
        TreeFactory.makeTree(root2, array);
        BinaryTreeMain0921.printBinaryTreeWidthFirst(root);
        System.out.println("-------------下面是测试TreeFactory-------------");
        BinaryTreeMain0921.printBinaryTreeWidthFirst(root2);
        System.out.println("深度是： " + BinaryTreeMain0921.computeTreeDepthBFS(root2) + " " + computeTreeDepthBFS(root2));

        System.out.println("-------------下面是测试z字遍历二叉树-------------");
        printZOrder(root2);
        System.out.println("正确结果: " + getLogStr(printz(root2)));

    }

    private static int computeTreeDepthBFS(BinaryNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        LinkedList<BinaryNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        while (!linkedList.isEmpty()) {
            depth++;
            int size = linkedList.size();
            while (size > 0) {
                root = linkedList.poll();
                if (root.left != null) {
                    linkedList.offer(root.left);
                }
                if (root.right != null) {
                    linkedList.offer(root.right);
                }
                size--;
            }
        }
        return depth;
    }

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

    /**
     * 从网上找的例子，用来做为参考
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> printz(BinaryNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) return list;//注意考虑到空元素，并且此时返回list，不是null
        Stack<BinaryNode> stack1 = new Stack<>();
        Stack<BinaryNode> stack2 = new Stack<>();
        stack2.add(pRoot);
        while (!stack2.isEmpty() || !stack1.isEmpty()) {
            ArrayList<Integer> subList = new ArrayList<>();
            if (!stack2.isEmpty()) {
                //需要将stack2中的元素全部弹出，此时才是该层的所有节点
                while (!stack2.isEmpty()) {
                    BinaryNode curNode = stack2.pop();
                    subList.add(curNode.value);
                    //弹出stack2中的元素的同时，需要将其中元素的左->右节点压入栈stack1
                    if (curNode.left != null) stack1.add(curNode.left);
                    if (curNode.right != null) stack1.add(curNode.right);
                }
                list.add(subList);
            } else {
                //需要将stack1中的元素全部弹出，此时才是该层的所有节点
                while (!stack1.isEmpty()) {
                    BinaryNode curNode1 = stack1.pop();
                    subList.add(curNode1.value);
                    //弹出stack1中的元素的同时，需要将其中元素的右->左节点压入栈stack2
                    if (curNode1.right != null) stack2.add(curNode1.right);
                    if (curNode1.left != null) stack2.add(curNode1.left);
                }
                list.add(subList);
            }
        }
        return list;
    }

    private static String getLogStr(ArrayList<ArrayList<Integer>> list) {
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> allList = new ArrayList<>();
        for (ArrayList<Integer> subList : list) {
            allList.addAll(subList);
        }
        return allList.toString();
    }
}
