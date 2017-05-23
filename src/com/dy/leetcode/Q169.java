package com.dy.leetcode;

public class Q169 {
	public int majorityElement(int[] nums) {
		//记录次数cnt和当前数值value
		//数值相同，cnt++,否则cnt--
		//当cnt为0,重置value和cnt
		int value = nums[0];
		int cnt = 1;
		for (int i = 1; i < nums.length; i++) {
			if(value == nums[i]){
				cnt++;
			}else{
				cnt--;
				if(cnt == 0){
					value = nums[i];
					cnt++;
				}
			}
		}
		return value;

	}
}
