package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q22_1 {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		addPairs(res, "", n, 0);
		return res;
	}
	public void addPairs(List<String> res, String s, int l, int r){
		System.out.println("|"+s+"|"+l+"|"+r+"|");
		if(l == 0 && r == 0){
			res.add(s);
			return;
		}
		if(r > 0){
			addPairs(res, s+")", l, r-1);
		}
		if(l > 0){
			addPairs(res, s+"(", l-1, r+1);
		}
	}
	public static void main(String[] args) {
		Q22_1 q = new Q22_1();
		List<String> res = q.generateParenthesis(3);
		System.out.println(res.size());
		for (String string : res) {
			System.out.println(string);
		}
	}

}
