package com.grass.interview.suanfa.tree;

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

    }
}
