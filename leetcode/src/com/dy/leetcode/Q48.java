package com.dy.leetcode;

public class Q48 {

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int len = matrix.length - 1;
		for (int i = 0; i < (len + 1) / 2; i++) {
			int start = i;
			int end = len - i;

			for (int j = start; j < end; j++) {
				int t1 = matrix[i][j];
//				System.out.println(matrix[end - j+start][i]);
				matrix[i][j] = matrix[end - j+start][i];
				int t2 = matrix[j][len - i];
				matrix[j][len - i] = t1;
				int t3 = matrix[len-i][end - j+start];
				matrix[len-i][end - j+start] = t2;
				// int t4 = matrix[end - j][i];
				matrix[end - j+start][i] = t3;

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
		Q48 q = new Q48();
		int cnt = 0;
		int len = 7;
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
