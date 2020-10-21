package com.grass.interview.suanfa;

/**
 * 最大子序和（动态规划讲解）
 *
 * 技术方案：
 *     1. 初始化两个变量：sum(连续子数组的累加和)、max(最大值)
 *     2. 遍历数组元素，考虑sum的情况：
 *         sum >= 0，将当前元素的值进行累加
 *         sum < 0，注意，sum的值为负值，不管当前的元素值是什么，累加sum(负数)肯定值最终会变小的，所以此刻，要重新对sum进行赋值操作
 *     3. 每次遍历时，都要比较sum和max的大小， 如果 sum > max，进行赋值max = sum
 *     4. 返回最终的结果max
 *
 * 作者：胡哥有话说
 * 链接：https://juejin.im/post/6844904143753052168
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int a = maxSubArray(nums);
        System.out.println(a);
        System.out.println(maxSonNum4(nums));
        System.out.println(maxSubArray2(nums));
    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {//这种遍历是从数组nums依次遍历出num（数组中的值）
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    private static int maxSonNum4(int[] a) {
        int maxSum = 0, sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > maxSum) {
                maxSum = sum;
            } else if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static int maxSubArray2(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > dp[k]) k = i;
        }
        return dp[k];
    }
}
