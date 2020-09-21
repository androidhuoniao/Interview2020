package com.grass.interview.suanfa.search;

import com.grass.interview.utils.LogUtils;

public class FindMedianMain {
    public static void main(String[] args) {
        int[] arr = {
                1,12, 3, 10, 8, 6, 7, 11, 13, 9};
        int median = findMedian(arr, arr.length);
        System.out.println("中位数：\n" + median);
        System.out.println(LogUtils.getLogStr(arr));
    }

    // 查找无序数组的中位数
    private static int findMedian(int arr[], int len) {
        int low = 0;
        int high = len - 1;
        int mid = (len - 1) / 2;
        int div = partSort(arr, low, high);

        while (div != mid) {
            if (mid < div) {
                // 左半区查找
                div = partSort(arr, low, div - 1);
            } else {
                // 右半区查找
                div = partSort(arr, div + 1, high);
            }
        }
        // 找到中位数
        return arr[mid];
    }

    final static int partSort(int arr[], int start, int end) {
        int low = start;
        int high = end;

        // 读取关键字
        int key = arr[end];
        while (low < high) {
            // 左边的值比key大的值
            while (low < high && arr[low] <= key) {
                ++low;
            }
            // 右边找比key小的值
            while (low < high && arr[high] >= key) {
                --high;
            }
            if (low < high) {
                // 找到之后交换左右的值
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }

        }

        int temp = arr[high];
        arr[high] = arr[end];
        arr[end] = temp;

        return low;
    }

}
