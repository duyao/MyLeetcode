package com.dy.leetcode;

public class Q153 {
	public int findMin(int[] nums) {
		int low = 0, high = nums.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (mid == low) {
				return nums[high] < nums[mid] ? nums[high] : nums[mid];
			}
			if (mid == high) {
				return nums[low] < nums[mid] ? nums[low] : nums[mid];
			}
			if (nums[low] < nums[mid] && nums[mid] < nums[high]) {
				return nums[low];
			} else if (nums[low] > nums[mid] && nums[mid] < nums[high]) {
				high = mid;
			} else if (nums[low] < nums[mid] && nums[mid] > nums[high]) {
				low = mid;
			}
		}
		return nums[0];

	}

	public static void main(String[] args) {
		int[] a = {1};
		Q153 q = new Q153();
		int x = q.findMin(a);
		System.out.println(x);
	}

}
