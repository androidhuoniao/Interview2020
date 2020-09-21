package com.grass.interview;

public class Utils {
    public static void swap(int[] array, int leftIndex, int rightIndex) {
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
