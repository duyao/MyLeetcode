package com.dy.leetcode;

import java.util.Arrays;

/**
 * Created by amy on 2017/3/22.
 */
public class Q300_1 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }

        return len;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = lengthOfLIS(nums);
        System.out.println(i);
    }
}
