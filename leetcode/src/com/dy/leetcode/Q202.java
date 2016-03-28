package com.dy.leetcode;

public class Q202 {
	public boolean isHappy(int n) {
		if (n < 0) {
			return false;
		}
		int sum = 0;
		while (true) {

			while (n != 0) {
				sum += (n % 10) * (n % 10);
				n /= 10;
			}
			if (sum == 1) {
				return true;
			} else if (sum < 10) {
				return false;
			} else {
				n = sum;
				sum = 0;
			}

		}

	}

	public static void main(String[] args) {
		Q202 q = new Q202();
		boolean b = q.isHappy(22);
		System.out.println(b);
	}

}
