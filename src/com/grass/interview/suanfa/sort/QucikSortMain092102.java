package com.grass.interview.suanfa.sort;

import com.grass.interview.utils.Utils;
import com.grass.interview.utils.LogUtils;


public class QucikSortMain092102 {
    public static void main(String[] args) {
        int[] array = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(array, 0, array.length - 1);
        System.out.println(LogUtils.getLogStr(array));
    }

    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = qsort(array, low, high);
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int qsort(int[] array, int low, int high) {
        int pivotValue = getPivotVaule(array, low, high);
        while (low < high) {
            while (array[high] >= pivotValue && low < high) {
                high--;
            }
            Utils.swap(array, low, high);
            while (array[low] <= pivotValue && low < high) {
                low++;
            }
            Utils.swap(array, low, high);
        }
        return low;
    }


    private static int getPivotVaule(int[] array, int low, int high) {
        int mid = (high + low) / 2;
        if (array[low] > array[high]) {
            Utils.swap(array, low, high);
        }
        if (array[mid] > array[high]) {
            Utils.swap(array, mid, high);
        }
        if (array[mid] > array[low]) {
            Utils.swap(array, mid, low);
        }
        return array[low];
    }

}
