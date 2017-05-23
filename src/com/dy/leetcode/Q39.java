package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q39 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		f(0, candidates, target, new ArrayList<Integer>(), res);
		System.out.println(res);
		return res;
	}

	public void f(int i, int[] candidates, int target, List<Integer> cur,
			List<List<Integer>> res) {
		if (target == 0) {
			List<Integer> tmp = new ArrayList<Integer>(cur);
			res.add(tmp);
		} else if(target > 0){
			for (int j = i; j < candidates.length; j++) {
				if(j > 0 && candidates[j] == candidates[j-1]){
					continue;
				}
				cur.add(candidates[j]);
				f(j + 1, candidates, target - candidates[j], cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Q39 q = new Q39();
		int[] candidates = { 1, 2, 3, 4, 5, 7 };
		int target = 7;
		q.combinationSum(candidates, target);
	}

}
