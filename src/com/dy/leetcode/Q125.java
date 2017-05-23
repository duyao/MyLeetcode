package com.dy.leetcode;
public class Q125 {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char ci = f(s, i);
			char cj = f(s, j);
			while (ci == ' ') {
				if (++i < s.length()) {
					ci = f(s, i);
				}else{
					break;
				}
			}
			while (cj == ' ') {
				if (--j > -1) {
					cj = f(s, j);
				}else{
					break;
				}
			}
			if (ci != cj) {
				return false;
			}
			i++;
			j--;
		}
		return true;

	}

	public char f(String s, int i) {
		char c = s.charAt(i);
		if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
			return c;
		} else if (c >= 'A' && c <= 'Z') {
			c += 32;
			return c;
		} else {
			return ' ';
		}
	}

	public static void main(String[] args) {
		Q125 q = new Q125();
		boolean b = q.isPalindrome("00p");
		System.out.println(b);
	}

}
