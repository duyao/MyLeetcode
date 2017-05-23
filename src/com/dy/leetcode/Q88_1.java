package com.dy.leetcode;

public class Q88_1 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		int cnt = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] >= nums2[j]) {
				nums1[cnt--] = nums1[i--];
			} else {
				nums1[cnt--] = nums2[j--];
			}

		}
		while (i >= 0) {
			nums1[cnt--] = nums1[i--];
		}
		while (j >= 0) {
			nums1[cnt--] = nums2[j--];
		}

	}

	public static void main(String[] args) {
		int[] nums1 = new int[10];
		int[] nums2 = { 3, 10 };
		for (int i = 0; i < 5; i++) {
			nums1[i] = 2 * i;
		}
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i] + ",");
		}
		System.out.println();
		Q88_1 q = new Q88_1();
		q.merge(nums1, 5, nums2, 2);
		for (int i = 0; i < 7; i++) {
			System.out.print(nums1[i] + ",");
		}
		System.out.println();

	}

}
