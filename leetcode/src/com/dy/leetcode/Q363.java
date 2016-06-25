package com.dy.leetcode;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Q363 {
	//找出最大的
	public int maxSumSubmatrix0(int[][] matrix, int k) {

		int maxSum = 0;
		int up = 0;
		int down = 0;
		int right = 0;
		int left = 0;
		for (int i = 0; i < matrix[0].length; i++) {
			int a[] = new int[matrix.length];
			for (int j = i; j < matrix[0].length; j++) {
				// 填充a
				for (int h = 0; h < matrix.length; h++) {
					a[h] += matrix[h][j];
				}
				// 找到最大值
				int tmpSum = 0;
				int s = 0;
				int e = 0;
				int dp[] = new int[a.length];
				dp[0] = a[0] > 0 ? a[0] : 0;
				for (int h = 1; h < a.length; h++) {
					dp[h] = dp[h-1] + a[h] > 0 ? dp[h-1] + a[h] : 0;
					
					if (dp[h] > tmpSum) {
						tmpSum = dp[h];
						if (dp[h - 1] > 0) {
							e = h;
						} else {
							s = h;
						}
					}
				}
				if (tmpSum > maxSum) {
					maxSum = tmpSum;
					up = s;
					down = e;
					left = i;
					right = j;
				}

			}
		}
		System.out.println("up"+up+"down"+down+"left"+left+"right"+right);
		return maxSum;
	}
	//最大且小于k
	public int maxSumSubmatrix(int[][] matrix, int k) {

		int maxSum = 0;
		int up = 0;
		int down = 0;
		int right = 0;
		int left = 0;
		int maxx = matrix[0][0];
		for (int i = 0; i < matrix[0].length; i++) {
			int a[] = new int[matrix.length];
			for (int j = i; j < matrix[0].length; j++) {
				// 填充a
				for (int h = 0; h < matrix.length; h++) {
					a[h] += matrix[h][j];
					
				}
				
				// 找到最大值

				int tmpSum = 0;
				
				int s = 0;
				int e = 0;
				int dp[] = new int[a.length];
				Set<Integer> set = new TreeSet<Integer>();
				for (Integer integer : a) {
					tmpSum += integer;
					
				}				
				

			}
		}
		System.out.println("up"+up+"down"+down+"left"+left+"right"+right);
		return maxSum;
	}
	public static void main(String[] args) {
		Q363 q = new Q363();
//		int [][] matrix = {{1,3,1}, {2,2,3}};
		int [][] matrix = {{-1,-3,-1}, {-2,-2,3}};
		int x = q.maxSumSubmatrix(matrix, 0);
		System.out.println(x);
	}

}
