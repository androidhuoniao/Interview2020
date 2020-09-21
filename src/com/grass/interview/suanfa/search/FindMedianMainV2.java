package com.grass.interview.suanfa.search;

import com.grass.interview.utils.LogUtils;

public class FindMedianMainV2 {

    public static void main(String[] args) {
        int[] arr = {
                1, 12, 3, 10, 8, 6, 7, 11, 13, 9};
        int median = findMedian(arr, arr.length);
        System.out.println("中位数：\n" + median);
        System.out.println(LogUtils.getLogStr(arr));
    }

    private static int findMedian(int[] arr, int length) {
        int mid = (length - 1) / 2;
        int low = 0;
        int high = length - 1;
        int pivoitIndex = qsort(arr, 0, length - 1);
        while (pivoitIndex != mid) {
            if (pivoitIndex < mid) {
                pivoitIndex = qsort(arr, low, pivoitIndex - 1);
            } else {
                pivoitIndex = qsort(arr, pivoitIndex + 1, high);
            }
        }
        return arr[mid];
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
