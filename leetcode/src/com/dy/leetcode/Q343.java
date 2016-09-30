package com.dy.leetcode;

/**
 * Created by dy on 2016/9/29.
 */
public class Q343 {
	//规律法
//	5 = 3 + 2
//	6 = 3 + 3
//	7 = 3 + 4
//	8 = 3 + 3 + 2
//	9 = 3 + 3 + 3
//	10 = 3 + 3 + 4
	//结尾以2, 3, 4循环，每一轮多出一个3

	public int integerBreak(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		} else if (n == 4) {
			return 4;
		}
		if (n % 3 == 2) {
			int t = (n - 2) / 3;
			return 2 * (int) Math.pow(3, t);
		} else if (n % 3 == 0) {
			int t = (n) / 3;
			return (int) Math.pow(3, t);
		} else if (n % 3 == 1) {
			int t = (n - 4) / 3;
			return 4 * (int) Math.pow(3, t);
		}

		return 0;
	}

	public static void main(String[] args) {
		Q343 q = new Q343();
		q.integerBreak(5);

	}
}

