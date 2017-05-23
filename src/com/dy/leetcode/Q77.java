package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q77 {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        f(1, n, k, new ArrayList<Integer>(), res);
        return res;
    }

	public void f(int x, int n, int k, List<Integer> cur, List<List<Integer>> res) {
		if (cur.size() == k) {
			List<Integer> tmp = new ArrayList<Integer>(cur);
			res.add(tmp);
			return;
		} else {
			cur.add(x);
			if(x <= n){
				f(x + 1, n, k, cur, res);
			}
			cur.remove(cur.size() - 1);
			if(x <= n){
				f(x + 1, n, k, cur, res);
			}
		}
	}

	public static void main(String[] args) {
		Q77 q = new Q77();
		List<List<Integer>> list = q.combine(4, 3);
		System.out.println(list);
	}

}
