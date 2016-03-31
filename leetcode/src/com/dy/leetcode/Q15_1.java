package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q15_1 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		for(int i = 0; i < nums.length; i++){
			int low = i + 1;
			int high = nums.length - 1;
			while(low < high){
				if(nums[low] + nums[high] < -nums[i]){
					low++;
				}else if(nums[low] + nums[high] > -nums[i]){
					high--;
				}else{
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[low]);
					list.add(nums[high]);
					res.add(list);
					low++;
					high--;
				}
			}
		}
		return new ArrayList<List<Integer>>(res);

	}
	public static void main(String[] args) {
		Q15_1 q = new Q15_1();
		int[] nums = { 0,1,1, 2,0,0, -2, -1 };

		List<List<Integer>> list = q.threeSum(nums);
		for (List<Integer> l : list) {
			for (Integer integer : l) {
				System.out.print(integer + ",");
			}
			System.out.println();

		}


	}
	

}
