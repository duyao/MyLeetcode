package com.dy.leetcode;

public class Q204 {
	public static boolean[] isPrimes(int n) {
		boolean[] b = new boolean[n];
		for (int i = 2; i < n; i++) {
			b[i] = true;
		}
		for (int i = 2; i * i <= n; i++) {
			if (!b[i]) {
				continue;
			}
			for(int j = i*i; j < n; j+=i){
				b[j] = false;
			}
		}
		return b;
	}

	public static int countPrimes(int n) {
		boolean[] b = isPrimes(n);
		int count = 0;
		   for (int i = 2; i < n; i++) {
		      if (b[i]) count++;
		   }
		   return count;
	}
	public static void main(String[] args) {
		countPrimes(12);
	}

}
