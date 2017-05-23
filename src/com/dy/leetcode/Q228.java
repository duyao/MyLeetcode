package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q228 {
	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		if (nums == null || nums.length == 0) {
			return list;
		}
		String s = String.valueOf(nums[0]);
		int head = nums[0];
		for (int i = 1; i <= nums.length; i++) {
			if (i == nums.length || nums[i] != nums[i - 1] + 1 ) {
				if(nums[i-1] != head){
					s += "->" + String.valueOf(nums[i - 1]);
				}
				list.add(s);
				if(i != nums.length){
					s = String.valueOf(nums[i]);
					head = nums[i];
				}
				
			}
		}
		return list;
	}
}
