package com.dy.leetcode;

public class Q74 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null){
			return false;
		}
		int i = 0;
		int j = matrix.length * matrix[0].length-1;
		int w = matrix[0].length;
		while(i <= j){
			int m = (i+j)/2;
			if(target == matrix[m/w][m%w]){
				return true;
			}else if(target < matrix[m/w][m%w]){
				j = m -1;
			}else{
				i = m + 1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] m = { {1,   3,  5,  7},
				  {10, 11, 16, 20},
				  {23, 30, 34, 50}};
		Q74 q = new Q74();
		boolean b = q.searchMatrix(m, 10);
		System.out.println(b);
	}
	

}
