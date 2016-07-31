package com.dy.leetcode;

public class Q63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
			return 0;
		}
		int[][] dp = new int[m][n];
		dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				dp[0][j] = 0;
				for(int i = j + 1; i < n; i++){
					dp[0][i] = 0;
				}
				break;
			} else {
				dp[0][j] = obstacleGrid[0][j] == 1 ? 0 : 1;
			}

		}
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				dp[i][0] = 0;
				for(int j = i + 1; j < m; j++){
					dp[j][0] = 0;
				}
				break;
			} else {
				dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : 1;
			}
		}
		myPrint(dp);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j]
						+ dp[i][j - 1];

			}
		}
		myPrint(dp);
		return dp[m - 1][n - 1];

	}

	public void myPrint(int[][] dp) {
		for (int[] is : dp) {
			for (int i : is) {

				System.out.print(i + ",");
			}
			System.out.println();
		}
		System.out.println("==================");
	}

	public static void main(String[] args) {
		Q63 q = new Q63();
		// int[][] a = { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 0, 0 } };
		int[][] a = { { 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		q.uniquePathsWithObstacles(a);
	}
}
