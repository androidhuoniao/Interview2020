package com.grass.interview.suanfa.tree;

/**
 * Created by grassswwang
 * on 2020/9/20
 * Email: grassswwang@tencent.com
 */
public class BinaryTreeUtils {

    public static void createBinaryTree(BinaryNode root, int[] array) {
        root.value = array.length > 0 ? array[0] : -1;
        for (int i = 1; i < array.length; i++) {
            insertBinaryTreeNode(root, array[i]);
        }
    }


    private static void insertBinaryTreeNode(BinaryNode root, int value) {
        if (root.value >= value) {
            if (root.left == null) {
                root.left = new BinaryNode(value);
                return;
            } else {
                insertBinaryTreeNode(root.left, value);
            }

        } else {
            if (root.right == null) {
                root.right = new BinaryNode(value);
                return;
            } else {
                insertBinaryTreeNode(root.right, value);
            }
        }
    }

}
