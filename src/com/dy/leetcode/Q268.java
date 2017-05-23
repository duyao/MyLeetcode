package com.dy.leetcode;

public class Q268 {
	public int missingNumber(int[] nums) {
		int k = nums.length;
		for (int i = 0; i < nums.length; i++) {
			// 可能会溢出
			// k = k ^ i ^ nums[i];
			k ^= i;
			k ^= nums[i];
		}
		System.out.println(k);
		return k;
	}

	public int missingNumber1(int[] nums) {
		int k = nums.length;
		int sum = (0 + k) * (k + 1) / 2;
		for (int i : nums) {
			sum -= i;
		}
		System.out.println(sum);
		return sum;

	}

	public static void main(String[] args) {
		Q268 q = new Q268();
		int[] nums = { 1, 0, 2, 3 };
		q.missingNumber1(nums);
	}

}
