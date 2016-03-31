package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q15 {

	public List<List<Integer>> threeSum(int[] nums) {

		if (nums == null || nums.length < 3) {
			return new ArrayList<List<Integer>>();
		}
		Arrays.sort(nums);
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		// 3²ãÑ­»·
		for (int k = 0; k < nums.length; k++) {
			for (int i = k + 1; i < nums.length; i++) {
				HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
				// Ìí¼Ómap
				if (i == k+1 || nums[i] != nums[i - 1]) {
					for (int j = i + 1; j < nums.length; j++) {
						if (j == i + 1 || nums[j] != nums[j - 1]) {
							int tmp = nums[i] + nums[j];
							if (!map.containsKey(tmp)) {
								map.put(tmp, new ArrayList<Integer>());
							}
							List<Integer> list = map.get(tmp);
							list.add(nums[i]);
							list.add(nums[j]);
						}

					}

				}

				//
				if (map.containsKey(-nums[k])) {
					List<Integer> tmp = map.get(-nums[i]);
					for (int j = 0; j < tmp.size(); j += 2) {
						List<Integer> list = new ArrayList<Integer>();
						int s = Math.min(tmp.get(j), tmp.get(j + 1));
						int b = tmp.get(j) == s ? tmp.get(j + 1) : tmp.get(j);
						if (s > nums[i]) {
							list.add(nums[i]);
							list.add(s);
							list.add(b);
						} else {
							list.add(s);
							if (b > nums[i]) {
								list.add(nums[i]);
								list.add(b);
							} else {
								list.add(b);
								list.add(nums[i]);
							}

						}
						res.add(list);
					}
				}

			}

		}

		return new ArrayList<List<Integer>>(res);

	}

	public static void main(String[] args) {
		Q15 q = new Q15();
		int[] nums = { 1,0,0,0, 2, -2, -1 };

		List<List<Integer>> list = q.threeSum(nums);
		for (List<Integer> l : list) {
			for (Integer integer : l) {
				System.out.print(integer + ",");
			}
			System.out.println();

		}
		// HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		// List<Integer> k = new ArrayList<Integer>();
		// k.add(1);
		// k.add(2);
		// set.add(k);
		// List<Integer> f = new ArrayList<Integer>();
		// f.add(2);
		// f.add(1);
		// Collections.sort(f);
		// set.add(f);
		// System.out.println(set.size());
		//
		// System.out.println(f.equals(k));

	}
}
