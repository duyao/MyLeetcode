package com.dy.leetcode;

/**
 * Created by dy on 2016/9/29.
 */
public class Q343 {
	public int integerBreak(int n) {
		if(n == 1){
			return 0;
		}else if(n ==2){
			return 1;
		}else if(n ==3){
			return 2;
		}
		int k = n%3;
		double t = (double)n/3;
		int res= (int) Math.pow(3,t);
		return res*k;
	}
	public static void main(String[] args) {
		Q343 q = new Q343();
		q.integerBreak(5);

	}
}

