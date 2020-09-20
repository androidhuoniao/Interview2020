package com.grass.interview.suanfa.sort;

/**
 * Created by grassswwang
 * on 2020/9/19
 * Email: grassswwang@tencent.com
 */
public class BinarySearchMain {
    public static void main(String[] args) {
        int[] arrays = new int[]{1, 2, 3, 5, 6, 8, 10};
        int i = indexValue(arrays, 4);
        System.out.println(i);

        int index2 = binarySearch(arrays, arrays.length, 4);
        System.out.println(index2);
    }

    private static int indexValue(int[] sortedArray, int value) {
        int index = -1;
        if (sortedArray == null || sortedArray.length == 0) {
            return index;
        }
        int start = 0;
        int end = sortedArray.length - 1;
        while (start <= end) {
            int middle = (end + start) / 2;
            if (sortedArray[middle] < value) {
                start = middle + 1;
            } else if (sortedArray[middle] > value) {
                end = middle - 1;
            } else {
                index = middle;
                return index;
            }
        }
        index = start;
        return index;
    }

    static int binarySearch(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }
}
