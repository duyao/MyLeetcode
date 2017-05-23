package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q315 {
	//binary search
	public static List<Integer> countSmaller(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
			return list;
		}
		List<Integer> sorted = new ArrayList<Integer>();
		sorted.add(nums[nums.length-1]);
		list.add(0);
		for(int i = nums.length-2; i >= 0; i--){
			int po = getIndex(nums[i], sorted);
			sorted.add(po,nums[i]);
			list.add(po);
		}
		Collections.reverse(list);
		return list;
		
	}
	//smaller exclude equal
	public static int getIndex(int val, List<Integer> sorted){
		int i = 0;
		int j = sorted.size();
		int mid;
		while(i < j){
			mid = (i+j)/2;
			if(val <= sorted.get(mid)){
				j = mid;
			}else{
				i = mid+1;
			}
			
		}
		return i;
	}

	

	public static void main(String[] args) {
		int[] nums = {12,34,4,3,7,5,2,6,1};
		Q315 q = new Q315();
		List<Integer> list = q.countSmaller(nums);
		System.out.println(list);
		
		
	}
}
