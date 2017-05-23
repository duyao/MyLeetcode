package com.dy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Q347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int value = 1;
			if (hash.containsKey(nums[i])) {
				value = hash.get(nums[i]) + 1;
			}
			hash.put(nums[i], value);
		}
		HashMap<Integer, List<Integer>> values = new HashMap<Integer, List<Integer>>();

		for (Integer i : hash.keySet()) {
			int v = hash.get(i);
			List<Integer> list = null;
			if (values.containsKey(v)) {
				list = values.get(v);
			} else {
				list = new ArrayList<Integer>();
			}
			list.add(i);
			values.put(v, list);
		}

		int[] keys = new int[values.size() + 1];
		int cnt = 1;
		for (Integer i : values.keySet()) {
			keys[cnt++] = i;
		}
		cnt = k;
		List<Integer> result = new ArrayList<Integer>();
		for (int i = keys.length; cnt > 0; i--) {
			keys = heapSort(keys, i);
			cnt -= values.get(keys[1]).size();
			int tmp = keys[1];
			keys[1] = keys[i - 1];
			keys[i - 1] = tmp;
			result.addAll(values.get(keys[i - 1]));
			if (cnt < 1) {
				return result;
			}

		}
		return null;

	}

	//Based on Q215
	public int[] heapSort(int[] nums, int len) {
		for (int parent = (len - 1) / 2; parent > 0; parent--) {
			int left = parent * 2;
			int right = left + 1;
			if (right < len && nums[left] < nums[right]) {
				left = right;
			}
			int tl =left, tp = parent;
			while (tl < len && nums[tl] > nums[tp]) {
				int tmp = nums[tl];
				nums[tl] = nums[tp];
				nums[tp] = tmp;
				tp = tl;
				tl = tp * 2;
				right = tl + 1;
				if (right < len && nums[tl] < nums[right]) {
					tl = right;
				}
			}
		}
		return nums;
	}

	public static void main(String[] args) {
		Q347 q = new Q347();
		int[] nums = { 5, -3, 9, 1, 7, 7, 9, 10, 2, 2, 10, 10, 3, -1, 3, 7, -9,
				-1, 3, 3 };
		int k = 3;
		List<Integer> list = q.topKFrequent(nums, k);
		System.out.println("x= " + list);
	}
}
