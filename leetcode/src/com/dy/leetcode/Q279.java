package com.dy.leetcode;

public class Q279 {
	public static int numSquares(int n) {
		int[] num = new int[n+1];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.MAX_VALUE;
		}
		num[1] = 1;
		for(int i = 2; i <= n ;i++){
			
			if(i*i <= n){
				num[i*i] = 1;
			}
			if(num[i] != 1){
				for(int j = 1;j*j <= i; j++){
					num[i] = Math.min(num[i], num[j*j]+num[i-j*j]);
				}
			}
			
		}
		return num[n];
	}
	public static void main(String[] args) {
		int x = numSquares(12);
		System.out.println(x);
	}
}
