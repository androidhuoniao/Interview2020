package com.grass.interview.suanfa.sort;

import com.grass.interview.utils.LogUtils;

/**
 * 1. 首先实现swap函数，暂时不识闲getPivotValue函数，写这个函数就复杂了
 * 2. 实现sort函数qSort函数
 */
public class QucikSortMain1009 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int[] array = new int[]{5, 1, 9, 3, 7, 6, 8, 5, 2};
//        int[] array = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(array, 0, array.length - 1);
        System.out.println(LogUtils.getLogStr(array));
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int midIndex = quickSort(array, low, high);
            sort(array, low, midIndex - 1);
            sort(array, midIndex + 1, high);
        }
    }

    private static int quickSort(int[] array, int low, int high) {
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
        return low;
    }

    /**
     * 三者取中，low中存放三个数中第二大的值
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int getPivotValue(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        if (array[low] < array[mid]) {
            swap(array, low, mid);
        }
        return array[low];
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
