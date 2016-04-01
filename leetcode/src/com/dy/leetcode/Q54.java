package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0){
			return list;
		}
		int rowBegin = 0;
		int rowEnd = matrix.length - 1;
		int colBegin = 0;
		int colEnd = matrix[0].length - 1;
		while (rowBegin <= rowEnd && colBegin <= colEnd) {
			for (int i = colBegin; i <= colEnd; i++) {
				list.add(matrix[rowBegin][i]);
			}
			for (int i = rowBegin + 1; i <= rowEnd; i++) {
				list.add(matrix[i][colEnd]);
			}
			for (int i = colEnd - 1; i >= colBegin && rowEnd - rowBegin > 0; i--) {
				list.add(matrix[rowEnd][i]);
			}
			for (int i = rowEnd - 1; i >= rowBegin + 1 && colEnd - colBegin > 0; i--) {
				list.add(matrix[i][rowBegin]);
			}
			rowBegin++;
			rowEnd--;
			colBegin++;
			colEnd--;

		}

		return list;

	}

	public static void main(String[] args) {
//		int[][] x = { { 1, 2, 3,10 }, { 4, 5, 6 ,11},{7, 8, 9 ,12},{7, 8, 9 ,12},{7, 8, 9 ,12},{7, 8, 9 ,12} };
		int[][] x = { };
		Q54 q = new Q54();
		List<Integer> list = q.spiralOrder(x);
		System.out.println(list);
	}

}
