package com.grass.interview.suanfa.tree;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by grassswwang
 * on 2020/9/20
 * Email: grassswwang@tencent.com
 * https://www.jianshu.com/p/4be7f3ba0b1a
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
        System.out.println("深度2：" + computeTreeDepth(root));
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

    /**
     * 层次遍历，计算二叉树的深度，并且打印每一层的最后一个节点
     * https://www.jianshu.com/p/4be7f3ba0b1a
     * @param binaryTree
     * @return
     */
    public static int computeTreeDepth(BinaryNode binaryTree) {
        //实例化队列
        Queue<BinaryNode> mVisitList = new LinkedList<>();
        BinaryNode tmp;
        int depth = 0, lengthTmp;
        if (binaryTree == null) {
            //根为空，直接返回0
            return 0;
        }
        //将根加入队列
        mVisitList.offer(binaryTree);
        while (!mVisitList.isEmpty()) {
            //只要队列不为空，说明新的一层数据不为空，且已经加到队列，深度+1
            depth++;
            //遍历该层到所有数据，将他们出队，并附带把所有下一层到数据都加进来(如果有的话)
            lengthTmp = mVisitList.size();
            // lenthTemp-- 大于0
            while (lengthTmp-- > 0) {
                tmp = mVisitList.poll();
                if (tmp.left != null) {
                    mVisitList.offer(tmp.left);
                }
                if (tmp.right != null) {
                    mVisitList.offer(tmp.right);
                }
                if (lengthTmp == 0) {
                    System.out.println("the last node in layer: "+tmp.value);
                }
            }
        }
        return depth;
    }

}
