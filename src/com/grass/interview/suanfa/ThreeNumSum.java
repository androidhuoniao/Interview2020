package com.grass.interview.suanfa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 最接近的三数之和---双指针
 */
class ThreeNumSum {

    public static void main(String[] args) {
        int[] array = {0, 3, 2, 8, 13, 4, 7, 4, 1, 0, 9, 3, 11, 2, 3, 5, 2};
        int num = 12;
        System.out.println(threeSumClosest(array, num));
    }

    public static int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            // 设置前后指针
            int start = i + 1;         // 前指针
            int end = nums.length - 1; // 后指针
            while (start < end) {
                // 记录遍历过程中的每一次三数和
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;  // 更新最接近target的三数之和
                if (target > sum)
                    start++;
                else if (target < sum)
                    end--;
                else
                    return ans;
            }
        }
        return ans;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
     * 返回其最大和,并顺序打印子序列。
     * @param array
     * @return
     */
    private static Integer subSequenceSum02(int[] array){
        int maxNum=0;
        Map<Integer, List<Integer>> subSequence=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int thisNum=0;
            List<Integer> list=new LinkedList<>();//保存子序列
            for (int j = i; j < array.length; j++) {
                thisNum+=array[j];   //子序列值累加,从开始累加到结尾计算出最大值
                list.add(array[j]);
                if(thisNum>maxNum){
                    maxNum=thisNum;
                    List<Integer> subList = new ArrayList<>();//每次都需要一个新集合,否则值会变
                    subList.addAll(list);
                    subSequence.put(maxNum,subList);//每一次最大值和对应子序列
                }
            }
        }
        System.out.println("算法二:"+Arrays.toString(subSequence.get(maxNum).toArray()));
        return maxNum;
    }

}
