package com.dy.leetcode;

/**
 * Created by dy on 2016/9/29.
 */
public class Q198_1 {
	public int rob(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}else if(nums.length == 1){
			return nums[0];
		}else if(nums.length == 2){

			return Math.max(nums[0],nums[1]);
		}
		int prior = nums[1];
		int pp = nums[0];
		int res = 0;
		for(int i = 2; i < nums.length; i++){
			pp = Math.max(pp,prior);
			prior = Math.max(prior, pp + nums[i]);
			res = Math.max(res,prior);

		}


		return res;


	}
}
