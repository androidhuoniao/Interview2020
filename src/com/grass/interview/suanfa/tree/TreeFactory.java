package com.grass.interview.suanfa.tree;

public class TreeFactory {
    public static BinaryNode makeTree(BinaryNode root, int[] array) {
        root.value = array.length > 0 ? array[0] : -1;
        for (int i = 1; i < array.length; i++) {
            insertTreeNode(root, array[i]);
        }
        return null;
    }

    private static void insertTreeNode(BinaryNode root, int i) {
        if (root.value >= i) {
            if (root.left == null) {
                root.left = new BinaryNode(i);
            } else {
                insertTreeNode(root.left, i);
            }
        } else {
            if (root.right == null) {
                root.right = new BinaryNode(i);
            } else {
                insertTreeNode(root.right, i);
            }
        }
    }
}
