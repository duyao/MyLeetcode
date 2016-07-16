package com.dy.leetcode;

public class Q73_1 {
	public void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		// ����row��col
		boolean col = false;
		boolean row = false;
		for (int i = 0; i < m; i++) {
			if (matrix[0][i] == 0) {
				col = true;
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 0) {
				row = true;
				break;
			}
		}
		// �����������õ�һ�е�һ��
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		// ���ݵ�һ�к͵�һ����������
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		// ���õ�һ�к͵�һ��
		if (row) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		if (col) {
			for (int i = 0; i < n; i++) {
				matrix[0][1] = 0;
			}
		}

	}

}
