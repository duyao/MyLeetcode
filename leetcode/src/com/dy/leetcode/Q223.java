package com.dy.leetcode;

public class Q223 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int a = (A-C)*(B-D);
		int b = (E-G)*(F-H);
		return a + b - cal(A,C,E,G)*cal(B,D,F,H);
		
	}

	public static int cal(int a, int b, int c, int d) {
		if (a == b || c == d) {
			return 0;
		}
		int m1 = Math.min(a, b);
		int m2 = Math.max(a, b);
		int m3 = Math.min(c, d);
		int m4 = Math.max(c, d);

		if (m1 <= m4 && m3 <= m2) {
			return Math.abs(Math.min(m2, m4)-Math.max(m1, m3));
		}

		return 0;
	}
	
	public static void main(String[] args) {
		
	}
}
