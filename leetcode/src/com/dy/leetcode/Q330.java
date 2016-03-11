package com.dy.leetcode;

public class Q330 {
	public int minPatches(int[] nums, int n) {

		long miss = 0;
		long sum = 0;
		int cnt = 0;
		int i = 0;

		while (sum < n) {
			if (i < nums.length && nums[i] <= sum + 1) {
				sum += nums[i++];
			} else {
				miss = sum + 1;
				sum += miss;
				cnt++;
			}
		}

		return cnt;

	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int n = 2147483647;
		Q330 q = new Q330();
		int x = q.minPatches(nums, n);
		System.out.println(x);
	}

}
