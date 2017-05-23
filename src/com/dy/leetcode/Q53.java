package com.dy.leetcode;

public class Q53 {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0] > 0 ? nums[0] : 0;
		int res = dp[0];
		int maxx = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], 0);
			res = Math.max(res, dp[i]);
			maxx = Math.max(nums[i], maxx);
		}
		if (maxx < 0 && maxx != Integer.MAX_VALUE) {
			return maxx;
		} else {
			return res;
		}
	}

	public int maxSubArray1(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int mx = 0, lmx = 0, rmx = 0, sum = 0;
		maxSubArray(nums, 0, nums.length - 1, mx, lmx, rmx, sum);
		return mx;
	}
		
	//????????
	public void maxSubArray(int[] nums, int l, int r, int mx, int lmx, int rmx,
			int sum) {
		if (l == r) {
			mx = lmx = rmx = sum = nums[l];
		}
		int m = (l + r) / 2;
		int mx1 = 0, lmx1 = 0, rmx1 = 0, sum1 = 0;
		int mx2 = 0, lmx2 = 0, rmx2 = 0, sum2 = 0;
		maxSubArray(nums, l, m, mx1, lmx1, rmx1, sum1);
		maxSubArray(nums, m + 1, r, mx2, lmx2, rmx2, sum2);
		mx = Math.max(Math.max(mx1, mx2), rmx1 + lmx2);
		lmx = Math.max(lmx1, sum1 + lmx2);
		rmx = Math.max(rmx2, sum2 + rmx1);
		sum = sum1 + sum2;

	}

	public static void main(String[] args) {
		Q53 q = new Q53();
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int x = q.maxSubArray1(nums);
		System.out.println(x);
		
	}
}
