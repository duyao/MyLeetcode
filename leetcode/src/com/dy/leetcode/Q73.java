package com.dy.leetcode;

public class Q73 {
	//如果真色是怎么办？
	public void setZeroes(int[][] matrix) {
		// 设置假色Integer.MIN_VALUE
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					change(matrix, i, j);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == Integer.MIN_VALUE|| matrix[i][j] == 0) {

					matrix[i][j] = 0;
				}
			}
		}

	}

	public void change(int[][] matrix, int a, int b) {

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][b] = matrix[i][b] == 0 ? 0 : Integer.MIN_VALUE;
		}
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[a][i] = matrix[a][i] == 0 ? 0 : Integer.MIN_VALUE;
		}

	}
	public static void main(String[] args) {
		int[][] m = {{-1}, {-2}, {-3}};
		Q73 q = new Q73();
		q.setZeroes(m);
	}

}
