package com.dy.leetcode;

public class Q287 {
	public int findDuplicate(int[] nums) {
		int fast = nums[0];
		int slow = 0;
		while (fast != slow) {
			fast = nums[nums[fast]];
			slow = nums[slow];
		}
		fast = 0;
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return slow;
	}

	public int findDuplicate1(int[] nums) {
		int s = 0;
		int e = nums.length - 1;
		while (s < e) {
			int cnt = 0;
			int m = (s + e) / 2;
			// 遍历所有的数字
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] <= m) {
					cnt++;
				}
			}
			if (m < cnt) {
				e = m;
			} else {
				s = m + 1;
			}

		}
		return s;

	}

}
