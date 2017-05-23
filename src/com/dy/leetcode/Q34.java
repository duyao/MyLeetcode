package com.dy.leetcode;

public class Q34 {
	public int[] searchRange(int[] nums, int target) {
		int s = 0;
		int e = nums.length - 1;

		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		while (s < e) {
			int m = (s + e) / 2;
			if(nums[m] < target){
				s = m+1;
			}else{
				e = m;
			}
		}

		if (nums[s] == target) {
			res[0] = s;
			e = nums.length - 1;
			while (s < e) {
				int m = (s + e) / 2;
				if (nums[m] <= target) {
					s = m + 1;
				} else {
					e = m;
				}

			}
			if (nums[s] == target) {
				res[1] = s;
			} else {
				res[1] = s - 1;
			}
		} else {
			res[0] = -1;
		}
		return res;

	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 9, 9,9,9,9,10 };
		int target = 7;
		Q34 q = new Q34();
		int[] res = q.searchRange(nums, target);
		System.out.println(res[0] + "," + res[1]);

	}

}
