package com.dy.leetcode;

public class Q171 {
	public int titleToNumber(String s) {
		int cnt = 1;
		int res = 0;
		for(int i = s.length()-1 ; i >= 0; i--){
			res += (s.charAt(i)-64)*cnt;
			cnt *= 26;
		}
		return res;
	}

}
