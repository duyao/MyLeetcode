package com.dy.leetcode;

import java.util.Arrays;

public class Q31 {
	public void nextPermutation(int[] nums) {
		boolean flag = false;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				for (int j = nums.length - 1; j >= i; j--) {
					// 交换
					if (nums[i - 1] < nums[j]) {
						int tmp = nums[i - 1];
						nums[i - 1] = nums[j];
						nums[j] = tmp;
						break;
					}
				}
				// 排序[i-1,nums.length]
				Arrays.sort(nums, i, nums.length);
				flag = true;
				break;
			}
		}
		if(!flag){
			//没有找到
			Arrays.sort(nums);
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}

	
	public static void main(String[] args) {
		Q31 q = new Q31();
//		int[] nums = {1,3,2};
		int[] nums = { 2,3,1 };

		q.nextPermutation(nums);

	}

}
