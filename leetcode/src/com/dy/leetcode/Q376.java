package com.dy.leetcode;

/**
 * Created by dy on 2016/10/8.
 */
public class Q376 {
	public int wiggleMaxLength(int[] nums) {
		if( nums.length  <= 1){
			return nums.length;
		}else if (nums.length == 2){
			if(nums[0] == 0 && nums[1] == 0){
				return 1;
			}
			return  2;
		}
		int [] diff = new int[nums.length-1];
		int cnt = 0;
		for(int i = 1; i < nums.length; i++){
			if(nums[i] == nums[i-1]){
				diff[cnt++] = 0;
			}else{
				diff[cnt++] = nums[i] - nums[i-1] < 0 ? -1 : 1;
			}

		}
		int res = diff[0] == 0 ? 1 : 2;
		int pre = diff[0];
		for(int i = 1; i < cnt ; i++){
			if(pre != 0){
				if(diff[i]*pre < 0 ){
					res ++;
					pre  = diff[i];
				}
			}else{
				if(diff[i] != 0){
					res ++;
					pre = diff[i];
				}
			}

		}
		return res;
	}

}
