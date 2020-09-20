package com.grass.interview.suanfa.sort;

/**
 * Created by grassswwang
 * on 2020/9/20
 * Email: grassswwang@tencent.com
 */
public class QuickSortMain {
    public static void main(String[] args) {
//        int[] array = new int[]{5, 1, 9, 3, 7, 6, 8, 5, 2};
        int[] array = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
//        int pivot = getPivot(array);
//        int pivot2 = getPivot(array, 0, array.length - 1);
//        System.out.println("pivot: " + pivot + " pivot2: " + pivot2);
//        qSort(array, 0, array.length - 1);
        sort(array, 0, array.length - 1);
        System.out.println(getLogStr(array));

    }

    private static void sort(int[] array, int low, int high) {
        int pivot = qSort(array, low, high);
        if (low < pivot) {
            sort(array, low, pivot - 1);
        }
        if (pivot < high) {
            sort(array, pivot + 1, high);
        }
    }

    private static int qSort(int[] array, int low, int high) {
        int pivot = getPivot(array, low, high);
        while (low < high) {
            while (array[pivot] <= array[high]) {
                high--;
            }
            swap(array, pivot, high);
            while (array[low] <= array[pivot]) {
                low++;
            }
            swap(array, pivot, low);
        }
        return pivot;
    }

    private static int getPivot(int[] array) {
        int pivot = 0;
        if (array == null || array.length <= 2) {
            return pivot;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = (high + low) / 2;
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        pivot = array[mid];
        return pivot;
    }

    private static int getPivot(int[] array, int low, int high) {
        int pivot = 0;
        if (array == null || array.length <= 2) {
            return pivot;
        }
        int mid = (high + low) / 2;
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        pivot = array[mid];
        return pivot;
    }

    private static void swap(int[] array, int index1, int index2) {
        int value1 = array[index1];
        array[index1] = array[index2];
        array[index2] = value1;
    }

    private static <T> String getLogStr(T[] array) {
        StringBuffer sb = new StringBuffer();
        for (T t : array) {
            sb.append(t.toString()).append(" , ");
        }
        return sb.toString();
    }

    private static String getLogStr(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int t : array) {
            sb.append(t).append(" , ");
        }
        return sb.toString();
    }
}
