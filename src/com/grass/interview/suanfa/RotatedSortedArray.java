package com.grass.interview.suanfa;

public class RotatedSortedArray {

    public static void main(String[] args) {
        int[] numbers = {4, 5,6,7,1,2,3};
        int min = findMin(numbers);
        System.out.println(min);
    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] < nums[right]) {
                // middle可能是最小值
                right = middle;
            } else {
                // middle肯定不是最小值
                left = middle + 1;
            }
        }
        return nums[left];
    }

}
