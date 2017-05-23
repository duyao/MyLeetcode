package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		f(9, k, n, new ArrayList<Integer>(), res);
		System.out.println(res);
		return res;

	}

	public void f(int x, int k, int n, List<Integer> cur,
			List<List<Integer>> res) {
		if (n == 0) {
			if (cur.size() == k) {
				res.add(new ArrayList<Integer>(cur));
			}
		} else if(n > 0){
			for (int i = x; i > 0; i--) {
				cur.add(i);
				f(i - 1, k, n - i, cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		Q216 q = new Q216();
		q.combinationSum3(3, 9);
		
	}
}
