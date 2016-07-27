package com.dy.leetcode;

import java.util.Arrays;

public class Q31_1 {
	public void nextPermutation(int[] nums) {
		boolean flag = false;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				for (int j = nums.length - 1; j >= i; j--) {
					// ½»»»
					if (nums[i - 1] < nums[j]) {
						swap(nums, i-1, j);
						break;
					}
				}
				//reverse
				reverse(nums, i);
				flag = true;
				break;
			}
		}
		if(!flag){
			reverse(nums, 0);
		
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
	}

	public void reverse(int[] a, int s){
		int e = a.length - 1;
		while(s < e){
			swap(a, s++, e--);
		}
	}
	public void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
