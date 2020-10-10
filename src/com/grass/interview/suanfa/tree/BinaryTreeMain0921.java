package com.grass.interview.suanfa.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

    public int computeTreeDepthDFS(BinaryNode binaryTree){
        //实例化栈
        Stack<BinaryNode> mVisitList = new Stack<>();
        BinaryNode tmp = binaryTree;
        int depth = 0;//遍历过程中到最大深度
        while (tmp != null){
            if(tmp.left!= null || tmp.right != null){
                //如果有子树，将当前节点入栈，且更新最大深度
                mVisitList.push(tmp);
                depth = Math.max(depth, mVisitList.size());
                //因为是左子树优先，所以深度遍历下一个子节点的时候，优先左子树
                tmp = tmp.left != null ? tmp.left : tmp.right;
                continue;
            }
            //当前节点没有子树，直接更新最大深度（访问到当前节点到深度是栈的深度+1）
            depth = Math.max(depth, mVisitList.size() + 1);
            //此时回溯去找右子树
            while (!mVisitList.isEmpty()){
                if(mVisitList.peek().left != null && mVisitList.peek().right != tmp){
                    //如果栈顶节点的右子树不为空，且栈顶节点的右子树不等于正在访问的节点，访问右子树
                    tmp = mVisitList.peek().left;
                    break;
                }
                //说明当前栈顶节点的右子树为空，直接出栈，继续回溯
                // 且要更新当前节点，用于记录当前正在回溯的节点，避免死循环回溯
                tmp = mVisitList.pop();
            }
        }
        return depth;
    }

    public int computeTreeDepthBFS(BinaryNode binaryTree){
        //实例化队列
        Queue<BinaryNode> mVisitList = new LinkedList<>();
        BinaryNode tmp;
        int depth = 0, lengthTmp;
        if(binaryTree == null){
            //根为空，直接返回0
            return 0;
        }
        //将根加入队列
        mVisitList.offer(binaryTree);
        while (!mVisitList.isEmpty()){
            //只要队列不为空，说明新的一层数据不为空，且已经加到队列，深度+1
            depth ++;
            //遍历该层到所有数据，将他们出队，并附带把所有下一层到数据都加进来(如果有的话)
            lengthTmp = mVisitList.size();
            while (lengthTmp-- > 0){
                tmp = mVisitList.poll();
                if(tmp.left != null){
                    mVisitList.offer(tmp.left);
                }
                if(tmp.right != null){
                    mVisitList.offer(tmp.right);
                }
            }
        }
        return depth;
    }


}
