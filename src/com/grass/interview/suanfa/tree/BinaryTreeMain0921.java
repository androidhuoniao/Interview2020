package com.grass.interview.suanfa.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class BinaryTreeMain0921 {
    public static void main(String[] args) {
        int[] array = {8, 3, 5, 20, 15, 2, 29, 1, 4, 6, 13, 16, 21, 30};
        BinaryNode root = new BinaryNode(0);
        BinaryTreeUtils.createBinaryTree(root, array);

//        testPreOrder(root);
//        testAfterOrder(root);
        System.out.println("广度优先遍历：");
        printBinaryTreeWidthFirst(root);
        System.out.println("");
        System.out.println("深度优先遍历：");
        printBinaryTreeDepthFirst(root);
        System.out.println("");
        System.out.println("深度：" + calculateDepthBinaryTree(root));
    }

    public static void testPreOrder(BinaryNode root) {
        System.out.println("前序遍历开始-------------");
        printPreOrder(root);
        System.out.println("前序遍历结束-------------");
    }

    public static void testMidOrder(BinaryNode root) {

        System.out.println("前序遍历开始-------------");
        printPreOrder(root);
        System.out.println("前序遍历结束-------------");
    }

    public static void testAfterOrder(BinaryNode root) {
        System.out.println("后序遍历开始-------------");
        printAfterOrder(root);
        System.out.println("后序遍历结束-------------");
    }

    public static void printPreOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public static void printMidOrder(BinaryNode root) {

    }

    public static void printAfterOrder(BinaryNode root) {
        if (root == null) {
            return;
        }
        printPreOrder(root.left);
        printPreOrder(root.right);
        System.out.println(root.value);
    }

    public static void printBinaryTreeWidthFirst(BinaryNode root) {
        LinkedList<BinaryNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            BinaryNode node = list.poll();
            System.out.println(node.value);
            if (node.left != null) {
                list.offer(node.left);
            }
            if (node.right != null) {
                list.offer(node.right);
            }
        }
    }

    public static void printBinaryTreeDepthFirst(BinaryNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(String.valueOf(root.value));
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static int calculateDepthBinaryTree(BinaryNode root) {
        int depth = 0;

        return depth;
    }

    public void houxu2(BinaryNode t) {
        Stack<BinaryNode> q1 = new Stack();
        Map<Integer, Integer> map = new HashMap<>();
        while (!q1.isEmpty() || t != null) {
            if (t != null) {
                q1.push(t);
                map.put(t.value, 1); //t.value标记这个值节点出现的次数
                t = t.left;
            } else {
                t = q1.peek();
                if (map.get(t.value) == 2) {//第二次访问，抛出
                    q1.pop();
                    System.out.print(t.value + " ");
                    t = null;//需要往上走
                } else {
                    map.put(t.value, 2);
                    t = t.right;
                }

            }
        }
    }

    /**
     * 后序遍历 非递归
     * 双栈法
     *
     * @param root
     */
    public static void postOrder2(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        Stack<BinaryNode> output = new Stack<BinaryNode>();
        BinaryNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        while (output.size() > 0) {
            BinaryNode n = output.pop();
            System.out.print(n.value + "\t");
        }
    }

    public void houxu3(BinaryNode t)// q1和q2 q1要先右后左，先遍历右侧，q1先装右侧就把右侧放到前面，左侧放在上面（栈顶）
    {
        Stack<BinaryNode> q1 = new Stack();
        Stack<BinaryNode> q2 = new Stack();
        if (t == null)
            return;
        if (t != null) {
            q1.push(t);
        }
        while (!q1.isEmpty()) {
            BinaryNode t1 = q1.pop();
            q2.push(t1);
            if (t1.left != null) {
                q1.push(t1.left);
            }
            if (t1.right != null) {
                q1.push(t1.right);
            }
        }
        while (!q2.isEmpty()) {
            BinaryNode t1 = q2.pop();
            System.out.print(t1.value + " ");
        }
    }
}
