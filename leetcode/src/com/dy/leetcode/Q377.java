package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q377 {
	public int combinationSum4(int[] nums, int target) {
		int[] result = new int[target + 1];
		result[0] = 1;
		for (int i = 1; i <= target; ++i) {
			for (int x : nums) {
				if (i >= x) {
					result[i] += result[i - x];
				}
			}
		}
		for (int i = 0; i < result.length; i++) {

			System.out.print(result[i]+",");
		}
		return result[target];
	}

	public static void main(String[] args) {
		Q377 q = new Q377();
		int[] candidates = { 1, 2, 3 };
		int target = 4;
		q.combinationSum4(candidates, target);
	}

}
