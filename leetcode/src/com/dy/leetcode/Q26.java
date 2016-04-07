package com.dy.leetcode;

public class Q26 {
	public int removeDuplicates(int[] nums) {
		// new length
		int cnt = 0;
		// travel every num
		int p = 0;
		while (p < nums.length) {
			if (p == 0 || nums[p] != nums[p - 1]) {
				nums[cnt] = nums[p];
				cnt++;
				p++;
			} else {
				p++;
			}
		}
		return cnt;
	}

}
