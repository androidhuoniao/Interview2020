package com.grass.interview.suanfa.sort;


import com.grass.interview.utils.LogUtils;

import static com.grass.interview.utils.LogUtils.getLogStr;

/**
 * Created by grassswwang
 * on 2020/9/20
 * Email: grassswwang@tencent.com
 */
public class QuickSortMain {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        int[] array1 = new int[]{5, 1, 9, 3, 7, 6, 8, 5, 2};
        sort(array1, 0, array1.length - 1);
        System.out.println(getLogStr(array1));
    }

    private static void test2() {
        int[] array2 = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(array2, 0, array2.length - 1);
        System.out.println(getLogStr(array2));
    }

    private static void test3() {
        int[] array3 = new int[]{50, 10, 90, 30, 70, 40, 80, 60, 20};
        sort(array3, 0, array3.length - 1);
        System.out.println(getLogStr(array3));
    }

    private static void test4() {
        int[] array = new int[]{4, 5, 7, 8, 1, 2, 3, 6};
        sort(array, 0, array.length - 1);
        System.out.println(getLogStr(array));
    }

    private static void sort(int[] array, int low, int high) {
        int pivot = 0;
        if (low < high) {
            pivot = qSort(array, low, high);
            sort(array, low, pivot - 1);
            sort(array, pivot + 1, high);
        }
    }


    /**
     * qsort函数为什么返回low呢？
     * 因为在退出最外层的while循环的时候，low==high，并且是在列表的中间位置，
     * 就是枢轴
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int qSort(int[] array, int low, int high) {
        int pivot = getPivot(array, low, high);
        System.out.println("qSort: pivot: " + pivot);
        while (low < high) {
            while (array[high] >= pivot && low < high) {
                high--;
            }
            swap(array, low, high);
            while (array[low] <= pivot && low < high) {
                low++;
            }
            swap(array, low, high);
        }
        // 返回枢轴所在的位置
        return low;
    }

    /**
     * 三数取中法，然后将中间值存储在low的位置，为什么要存储在low的位置，我也不懂
     * https://www.yuque.com/wangshengwei-evzp3/te8s4z/ge0pt3
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    private static int getPivot(int[] array, int low, int high) {
        int pivot = 0;
        if (array == null || array.length <= 2) {
            pivot = low;
            return pivot;
        }
        int mid = (high + low) / 2;
        String oldList = "low: " + array[low] + " mid: " + array[mid] + " high: " + array[high];
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        if (array[mid] > array[low]) {
            swap(array, low, mid);
        }
//        String newList = "low: " + array[low] + " mid: " + array[mid] + " high: " + array[high];
//        System.out.println("oldList: " + oldList + "\n" + "newList: " + newList);
//        System.out.println(getLogStr(array));
        pivot = array[low];
        return pivot;
    }

    private static void swap(int[] array, int index1, int index2) {
        int value1 = array[index1];
        array[index1] = array[index2];
        array[index2] = value1;
    }


}
