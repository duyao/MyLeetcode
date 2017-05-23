package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return list;
		}
		List<String> info = new ArrayList<>();
		info.add("abc");
		info.add("def");
		info.add("ghi");
		info.add("jkl");
		info.add("mno");
		info.add("pqrs");
		info.add("tuv");
		info.add("wxyz");
		add(digits, info, 0, new StringBuffer(), list);
		return list;
	}

	public void add(String digits, List<String> info, int i, 
			StringBuffer sb, List<String> res) {
		
		
		if (i == digits.length()) {
			res.add(sb.toString());
			sb.deleteCharAt(sb.length() - 1);
			
		} else if (i < digits.length()) {
			int cur = digits.charAt(i) - 48 - 2;
			String tmp = info.get(cur);
			for (int k = 0; k < tmp.length(); k++) {
				sb.append(tmp.charAt(k));
				add(digits, info, i + 1, sb, res);
			}
			if(sb.length() != 0){
				sb.deleteCharAt(sb.length() - 1);
			}

		}

	}

	public static void main(String[] args) {
		Q17 q = new Q17();
		String digits = "23";
		List<String> list = q.letterCombinations(digits);
		System.out.println(list);

	}

}
