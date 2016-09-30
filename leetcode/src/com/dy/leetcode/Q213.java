package com.dy.leetcode;

/**
 * Created by dy on 2016/9/30.
 */
public class Q213 {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}else if(nums.length == 1){
			return nums[0];
		}else if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
		int max1 = 0;
		int prior = nums[1];
		int pp = nums[0];
		for(int i = 2; i < nums.length -1; i++){
			int tmp = prior;
			prior = Math.max(max1, nums[i]+pp);
			pp = Math.max(pp,tmp);
			max1 = Math.max(max1, prior);

		}

		int max2 = 0;
		prior = nums[2];
		pp = nums[1];
		for(int i = 3; i < nums.length; i++){
			int tmp = prior;
			prior = Math.max(max2, nums[i]+pp);
			pp = Math.max(pp,tmp);
			max2 = Math.max(max2, prior);

		}

		return Math.max(max1, max2);


	}

	public static void main(String[] args) {
	}
}
