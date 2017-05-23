package com.dy.leetcode;

public class Q27 {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int l = 0;
		int r = nums.length - 1;
		while (l < r) {
			if (nums[l] == val) {
				while (nums[r] == val && r > l) {
					r--;
				}
				if (nums[r] == val) {
					return l;
				} else {
					int t = nums[r];
					nums[r] = nums[l];
					nums[l] = t;
				}
			} else {
				l++;
			}

		}
		if (nums[l] == val) {
			//Ò»°ãÇé¿ö
			return l;
		} else {
			if (nums[r] != val) {
				//2,2,val =3
				return l + 1;
			} else {
				//3,3,val =2
				return 1;
			}
		}
	}

}
