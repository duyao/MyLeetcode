package com.dy.leetcode;

/**
 * Created by dy on 2016/9/29.
 */
public class Q198 {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		if(nums == null || nums.length == 0){
			return 0;
		}else if(nums.length == 1){
			return nums[0];
		}else if(nums.length == 2){

			return Math.max(nums[0],nums[1]);
		}
		dp[0]=nums[0];
		dp[1]= nums[1];
		for(int i = 2; i < nums.length; i++){
			int max = dp[i-1];
			for(int j = i-2; j >= 0; j--){
				max = Math.max(max,nums[i]+dp[j]);

			}
			dp[i] = max;
		}
		for (int i = 0; i < dp.length; i++) {
			System.out.print(dp[i]+",");
		}

		return dp[nums.length-1];

	}

	public static void main(String[] args) {
		Q198 q = new Q198();
		int [] a = new int[]{1,2,1,1};
		q.rob(a);

	}
}
