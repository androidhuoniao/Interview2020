package com.grass.interview.suanfa.heap;

import java.util.PriorityQueue;

/**
 * 求一组动态数据集合的最大 Top K
 */
public class GetTopKArrays {
    public static void main(String[] args) {
        GetTopKArrays getTopKArrays = new GetTopKArrays();
        int[] arrays = new int[10];
        for (int i = 0; i < 10; i++) {
            arrays[i] = i;
        }
        System.out.println("一组动态数据:");
        System.out.println(arrays);
        int k = 3;
        int[] result = getTopKArrays.topK(arrays, k);
        System.out.println("前三的数据为:");
        System.out.println(result);
    }


    private int[] topK(int[] arrays, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for (int i = 0; i < arrays.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(arrays[i]);
            } else {
                int value = priorityQueue.peek();
                if (arrays[i] > value) {
                    priorityQueue.poll();
                    priorityQueue.offer(arrays[i]);
                }
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            result[index++] = priorityQueue.poll();
        }
        return result;
    }
}
