package com.dy.leetcode;

public class Q48_1 {
	// clockwise
	// 1.up to down
	// 2. swap symmetry
	// anticlockwise
	// 1.left to right
	// 2.swap symmetry
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		// 1.up to down
		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int k = matrix.length - 1 - i;
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[k][j];
				matrix[k][j] = tmp;
			}

		}
		// 2. swap symmetry
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}

	}

	
	 
	
	public void print(int[][] num) {
		int len = num.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(num[i][j] + ",");

			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Q48_1 q = new Q48_1();
		int cnt = 0;
		int len = 5;
		int[][] num = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				num[i][j] = cnt++;
			}
		}
		System.out.println("=============before=============");
		q.print(num);
		System.out.println("=============after=============");
		q.rotate(num);
		q.print(num);

	}

}
