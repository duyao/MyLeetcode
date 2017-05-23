package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q91_2 {
	public int numDecodings(String s) {
		if(s == null || s.length() == 0){
			return 0;
		}else if(s.length() == 1){
			return 1;
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int sum = f(s, 0, 1, new ArrayList<Integer>()) + f(s, 0, 2, new ArrayList<Integer>());
		System.out.println(sum);
		return sum;
	}

	public int f(String s, int i, int j, List<Integer> path) {
		int cnt = 0;
		System.out.println("i=" + i + ",j=" + j);
		if (j == s.length()) {
			Integer tmp = Integer.valueOf(s.substring(i, j));
			if (tmp > 0 && tmp < 27) {
				path.add(tmp);
				cnt++;
				path.remove(path.size() - 1);
			}
			
		} else {

			Integer tmp = Integer.valueOf(s.substring(i, j));
			if (tmp > 0 && tmp < 27) {
				path.add(tmp);
				if (j + 1 <= s.length()) {
					cnt += f(s, j, j + 1, path);
				}
				if (j + 2 <= s.length()) {
					cnt += f(s, j, j + 2, path);
				}
				path.remove(path.size() - 1);
			}

		}
		return cnt;

	}

	public static void main(String[] args) {
		String s = "1314";
		Q91_2 q = new Q91_2();
		int x = q.numDecodings(s);
		System.out.println(x);
	}

}
