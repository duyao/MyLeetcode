package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		int size = 1 << nums.length;
		for(int i = 0; i < size; i++){
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < nums.length; j++) {
				if((i & (1 << j)) != 0){
					list.add(nums[j]);
				}
			}
			res.add(list);
		}
		return new ArrayList<List<Integer>>(res);
	}
	public static void main(String[] args) {
		int[] nums = {};
		Q90 q = new Q90();
		List<List<Integer>> res = q.subsetsWithDup(nums);
		System.out.println(res);
	}

}
