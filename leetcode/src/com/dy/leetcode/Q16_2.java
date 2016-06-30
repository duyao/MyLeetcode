package com.dy.leetcode;

import java.util.Arrays;

public class Q16_2 {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[2];
		for(int i = 0; i < nums.length - 2; i++){
			int s = i + 1;
			int e = nums.length - 1;
			while(s < e){
				int sum = nums[i] + nums[s] + nums[e];
				if(sum < target){
					s++;
				}else if(sum > target){
					e--;
				}else{
					return target;
				}
				if(Math.abs(target - sum) < Math.abs(target - res)){
					res = sum;
				}
			}
		}
		return res;

	}

}
