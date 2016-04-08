package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q91_1 {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0){
			return 0;
		}else if(s.length() == 1){
			return 1;
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		f(s, 0, 1, new ArrayList<Integer>(), res);
		f(s, 0, 2, new ArrayList<Integer>(), res);
		System.out.println(res);
		return res.size();

		// int l = 0;
		// int r = 1;
		// while (l < s.length() && r <= s.length()) {
		// String string = s.substring(l, r);
		// List<List<String>> tres1 = new ArrayList<List<String>>();
		// if (Integer.valueOf(string) > 0 && Integer.valueOf(string) < 27) {
		//
		// for (List<String> list : res) {
		// List<String> tmp = new ArrayList<String>(list);
		// tmp.add(string);
		// tres1.add(tmp);
		// }
		//
		// }
		// if(++r <= s.length()){
		// string = s.substring(l, r);
		// List<List<String>> tres2 = new ArrayList<List<String>>();
		// if (Integer.valueOf(string) > 0 && Integer.valueOf(string) < 27) {
		// for (List<String> list : res) {
		// List<String> tmp = new ArrayList<String>(list);
		// tmp.add(string);
		// tres2.add(tmp);
		// }
		//
		// }
		// if (tres2 != null) {
		// res = tres2;
		// }
		// }
		//
		// l++;
		// if (tres1 != null) {
		// res = tres1;
		// }
		//
		//
		// }
		// System.out.println(res);
		// return res.size();
	}

	public void f(String s, int i, int j, List<Integer> path,
			List<List<Integer>> res) {
		System.out.println("i=" + i + ",j=" + j);
		if (j == s.length()) {
			Integer tmp = Integer.valueOf(s.substring(i, j));
			if (tmp > 0 && tmp < 27) {
				path.add(tmp);
				res.add(new ArrayList<Integer>(path));
				path.remove(path.size() - 1);
			}
			
		} else {

			Integer tmp = Integer.valueOf(s.substring(i, j));
			if (tmp > 0 && tmp < 27) {
				path.add(tmp);
				if (j + 1 <= s.length()) {
					f(s, j, j + 1, path, res);
				}
				if (j + 2 <= s.length()) {
					f(s, j, j + 2, path, res);
				}
				path.remove(path.size() - 1);
			}

		}

	}

	public static void main(String[] args) {
		String s = "1";
		Q91_1 q = new Q91_1();
		int x = q.numDecodings(s);
		System.out.println(x);
	}

}
