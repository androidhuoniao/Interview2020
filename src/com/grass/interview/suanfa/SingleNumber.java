package com.grass.interview.suanfa;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ret = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }
}
