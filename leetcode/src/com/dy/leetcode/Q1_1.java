package com.dy.leetcode;

import java.util.HashMap;

public class Q1_1 {
	//将值和下标作为键值放入map中
	//每次值进入看map中是否有数字可以组成和
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])){
				return new int[]{target - nums[i],i};
			}else{
				map.put(nums[i], i);
			}
		}
		return null;

	}

}
