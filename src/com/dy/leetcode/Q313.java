package com.dy.leetcode;

public class Q313 {
	public int[] nthSuperUglyNumber(int n, int[] primes) {
		int[] res = new int[n];
		res[0] = 1;
		int j = 1;
		int c = primes[0];
		int cur = 0;
		for (int i = 1; i < n; i++) {

			if (j < primes.length && primes[j] < c * res[cur]) {
				res[i] = primes[j];
				j++;
			}

			else if (c * res[cur] == res[i - 1]) {
				cur++;
				i--;
			} else {
				res[i] = c * res[cur];
				cur++;
			}
		}
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		// System.out.println(res);
		return res;
		// return res[n-1];

	}

	public int[] nthSuperUglyNumber1(int n, int[] primes) {
		int[] ret = new int[n];
		ret[0] = 1;

		int[] indexes = new int[primes.length];

		for (int i = 1; i < n; i++) {
			ret[i] = Integer.MAX_VALUE;

			for (int j = 0; j < primes.length; j++) {
				ret[i] = Math.min(ret[i], primes[j] * ret[indexes[j]]);
			}

			for (int j = 0; j < indexes.length; j++) {
				if (ret[i] == primes[j] * ret[indexes[j]]) {
					indexes[j]++;
				} 
			}
		}
		return ret;
//		System.out.println("his" + ret[1085]);
//		return ret[n - 1];
	}

	public static void main(String[] args) {

		Q313 q = new Q313();
		int[] primes = { 2, 3,5};
		int[]a =q.nthSuperUglyNumber(40, primes);
		int[]b=q.nthSuperUglyNumber1(40, primes);
		for (int i = 0; i < b.length; i++) {
			if(a[i]!=b[i]){
				System.out.println("curPo = "+i+" , my = "+a[i]+" , his = "+b[i]);
			}
		}
	}

}
