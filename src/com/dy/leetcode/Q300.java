package com.dy.leetcode;

/**
 * Created by amy on 2017/3/22.
 */
public class Q300 {
    //o(n*n)
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (dp[j] + 1 > dp[i] && nums[i] > nums[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}
