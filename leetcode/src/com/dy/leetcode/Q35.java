package com.dy.leetcode;

public class Q35 {
	public int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int low = 0;
		int high = nums.length - 1;
		while (low <= high && low >= 0 && high <= nums.length) {
			int mid = (low + high) / 2;
			if (nums[mid] < target) {
				low = mid + 1;
			} else if (nums[mid] > target) {
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return low;

	}

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 8};
		Q35 q = new Q35();
		int x = q.searchInsert(a, 7);
		System.out.println(x);
		
	}

}
