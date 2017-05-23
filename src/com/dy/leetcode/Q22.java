package com.dy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q22 {
	public List<String> generateParenthesis(int n) {
		Set<String> res  = new HashSet<String>();
		res.add("");
		for (int i = 0; i < n; i++) {
			Set<String> tres  = new HashSet<String>();
			for (int j = 0; j <= i; j++) {
				for (String string : res) {
					StringBuffer sb = new StringBuffer(string);
					sb.insert(j,"()");
					tres.add(sb.toString());
				}
			}
			res = tres;
		}
		System.out.println(res.size());
		for (String string : res) {
			System.out.println(string);
		}
		return new ArrayList<String>(res);

	}
	public static void main(String[] args) {
		Q22 q = new Q22();
		List<String> res = q.generateParenthesis(0);
	}

}
