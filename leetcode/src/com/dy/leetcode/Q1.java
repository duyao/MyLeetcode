package com.dy.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Q1 {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				System.out.println("map.get(nums[i])" + map.get(nums[i]));
				System.out.println("nums[i]" + nums[i]);
				if (nums[i] + nums[map.get(nums[i])] == target) {
					System.out.println();
					return new int[] { map.get(nums[i]), i };
				}
			}

			
			

			map.put(nums[i], i);
		}
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1;
		while (i < j) {
			if (nums[i] + nums[j] < target) {
				i++;
			} else if (nums[i] + nums[j] > target) {
				j--;
			} else {
				return new int[] { map.get(nums[i]), map.get(nums[j]) };
			}
		}
		return new int[] { map.get(nums[i]), map.get(nums[j]) };

	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 9, 4, 4, 56, 90, 3 };
		int target = 8;
		Q1 q = new Q1();
		int[] b = q.twoSum(a, target);
		System.out.println(b[0] + "," + b[1]);
	}
}
