package com.grass.interview.suanfa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by grassswwang
 * on 2020/9/20
 * Email: grassswwang@tencent.com
 */
public class BinaryTreeMain {
    public static void main(String[] args) {
        int[] array = {8, 3, 5, 20, 15, 2, 29, 1, 4, 6, 13, 16, 21, 30};
        BinaryNode root = new BinaryNode(0);
        BinaryTreeUtils.createBinaryTree(root, array);
        System.out.println("广度优先遍历：");
        printBinaryTreeWidthFirst(root);
        System.out.println("");
        System.out.println("深度优先遍历：");
        printBinaryTreeDepthFirst(root);
        System.out.println("");
        System.out.println("深度：" + calculateDepthBinaryTree(root));
        ;
    }

    public static void printBinaryTreeWidthFirst(BinaryNode root) {
        Queue queue = new LinkedList();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {

            root = (BinaryNode) queue.poll();
            System.out.print(root.value + " ");

            if (root.left != null) {
                queue.offer(root.left);
            }

            if (root.right != null) {
                queue.offer(root.right);
            }

        }
    }

    //深度优先遍历
    public static void printBinaryTreeDepthFirst(BinaryNode root) {
        Stack stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = (BinaryNode) stack.pop();
            System.out.print(root.value + " ");

            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    //计算深度
    public static int calculateDepthBinaryTree(BinaryNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateDepthBinaryTree(root.left);
        int right = calculateDepthBinaryTree(root.right);
        return Math.max(left, right) + 1;
    }
}
