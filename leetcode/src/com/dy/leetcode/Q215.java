package com.dy.leetcode;

public class Q215 {
	public int findKthLargest(int[] nums, int k) {
		//初始化有问题
		int[] res = new int[nums.length+1];
		for (int i = 0; i < nums.length; i++) {
			res[i+1] = nums[i];
		}
		for (int i = 1; i < k; i++) {
			res = buildHeap(res, i, nums.length);
			System.out.println(res[1]);
		}
		return res[1];

	}

	public int[] buildHeap(int[] nums, int s, int e) {
		int[] res = new int[e - s + 1];
		// cnt是res.length
		int cnt = 1;
		for (int i = s; i < e; i++) {
			res[cnt++] = nums[i];
		}
		for (int parent = cnt / 2 - 1; parent > 0; parent--) {

			int left = parent * 2;
			int right = left + 1;
			if (right < cnt && res[left] < res[right]) {
				left = right;
			}

			while (left < cnt && res[parent] < res[left]) {
				int tmp = res[left];
				res[left] = res[parent];
				res[parent] = tmp;
				parent = left;
				left = parent * 2;
				right = left + 1;
				if (right < cnt && res[left] < res[right]) {
					left = right;
				}
			}

		}
		return res;

	}

	public static void main(String[] args) {

		Q215 q = new Q215();
		int[] nums = { -1,2,0};
		int k = 2;
		int x =q.findKthLargest(nums, k);
		
	}

}
