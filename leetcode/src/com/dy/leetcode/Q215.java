package com.dy.leetcode;

public class Q215 {
	public int findKthLargest(int[] nums, int k) {
		int[] res = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			res[i + 1] = nums[i];
		}
		for (int i = res.length; k > 0; i--,k--) {

			res = buildHeap(res, i);
			System.out.println(res[1]);
			int tmp = res[1];
			res[1] = res[i-1];
			res[i-1] = tmp;
			if(k == 1){
				return res[i-1];
			}
		}
		return 0;

	}

	public int[] buildHeap(int[] nums, int cnt) {

		for (int parent = (cnt-1) / 2 ; parent > 0; parent--) {

			int left = parent * 2;
			int right = left + 1;
			if (right < cnt && nums[left] < nums[right]) {
				left = right;
			}

//			while (left < cnt && res[parent] < res[left]) {
//				int tmp = res[left];
//				res[left] = res[parent];
//				res[parent] = tmp;
//				parent = left;
//				left = parent * 2;
//				right = left + 1;
//				if (right < cnt && res[left] < res[right]) {
//					left = right;
//				}
//			}
			//这里要使用临时变量，因为如果循环只有一次，那么改变parent就影响到下一次循环
			int tl =left, tp = parent;
			while (tl < cnt && nums[tl] > nums[tp]) {
				int tmp = nums[tl];
				nums[tl] = nums[tp];
				nums[tp] = tmp;
				tp = tl;
				tl = tp * 2;
				right = tl + 1;
				if (right < cnt && nums[tl] < nums[right]) {
					tl = right;
				}
			}

		}
		return nums;

	}

	public static void main(String[] args) {

		Q215 q = new Q215();
		int[] nums = { -2,9,2,1 };
		int k = 4;
		int x = q.findKthLargest(nums, k);
		System.out.println("x= " + x);
	}

}
