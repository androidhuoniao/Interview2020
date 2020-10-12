package com.grass.interview.suanfa.tree;

import java.util.LinkedList;

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
        System.out.println("深度是： "+BinaryTreeMain0921.computeTreeDepthBFS(root2)+" "+computeTreeDepthBFS(root2));

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
}
