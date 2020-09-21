package com.grass.interview.suanfa.sort;

import com.grass.interview.utils.LogUtils;

/**
 * 1. 首先实现swap函数，暂时不识闲getPivotValue函数，写这个函数就复杂了
 * 2. 实现sort函数qSort函数
 */
public class QucikSortMain0921 {
    public static void main(String[] args) {
        test1();
//        testSwap();
//        testGetPivotValue();
    }



    private static void testGetPivotValue() {
//        int[] array = new int[]{5, 1, 9, 3, 7, 6, 8, 5, 2};
        int[] array = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        int pivotValue = getPivotValue(array, 0, array.length - 1);
        System.out.println(pivotValue+" testGetPivotValue " + LogUtils.getLogStr(array));
    }
    private static void testSwap() {
        int[] array = new int[]{5, 1, 9, 3, 7, 6, 8, 5, 2};
        swap(array, 0, array.length - 1);
        System.out.println("testSwap: " + LogUtils.getLogStr(array));
    }

    private static void test1() {
//        int[] array = new int[]{5, 1, 9, 3, 7, 6, 8, 5, 2};
        int[] array = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(array, 0, array.length - 1);
        System.out.println(LogUtils.getLogStr(array));
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = qsort(array, low, high);
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex+1, high);
        }
    }

    private static int qsort(int[] array, int low, int high) {
        if (low < high) {
            int pivotValue = getPivotValue(array, low, high);
            while (low < high) {
                while (array[high] >= pivotValue && low < high) {
                    high--;
                }
                swap(array, low, high);
                while (array[low] <= pivotValue && low < high) {
                    low++;
                }
                swap(array, low, high);
            }
        }
        return low;
    }

    private static int getPivotValue(int[] array, int start, int end) {
        if (array == null || array.length <= 0) {
            return -1;
        }
        if (start >= array.length || end >= array.length) {
            return -1;
        }
        int gap = end - start;
        if (gap <= 1) {
            return array[start];
        }
        int mid = (end + start) / 2;
        if (array[start] > array[end]) {
            swap(array, start, end);
        }
        if (array[mid] > array[end]) {
            swap(array, mid, end);
        }
        if (array[mid] > array[start]) {
            swap(array, start, mid);
        }
        return array[start];
    }

    private static void swap(int[] array, int leftIndex, int rightIndex) {
        if (array == null) {
            return;
        }
        if (leftIndex >= array.length || rightIndex >= array.length) {
            return;
        }
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }
}
