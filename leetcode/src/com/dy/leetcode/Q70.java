package com.dy.leetcode;

public class Q70 {
	public static int climbStairs(int n) {
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else if(n ==2){
			return 2;
		}
		//dp[i]表示走i共有dp[i]种方法
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < n+1; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	public static void main(String[] args) {
		//1111,112,121,22,211
		int x = climbStairs(4);
		System.out.println(x);
	}
}
