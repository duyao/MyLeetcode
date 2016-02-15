package com.dy.leetcode;

public class Q304 {
	private int [][] sum;

	public Q304(int[][] matrix) {

		if(matrix.length != 0 && matrix[0].length != 0){
			sum = new int[matrix.length][matrix[0].length];
			
			sum[0][0] = matrix[0][0];
			
			for(int i = 1; i < matrix.length; i++){
				sum[i][0] = sum[i-1][0] + matrix[i][0];
			}
			for(int i = 1; i < matrix[0].length; i++){
				sum[0][i] = sum[0][i-1] + matrix[0][i];
			}
			
			for(int i = 1; i < matrix.length; i++){
				for(int j = 1; j < matrix[0].length; j++){
					sum[i][j] = sum[i-1][j] + sum[i][j-1] + matrix[i][j] - sum[i-1][j-1];
				}
			}
		}
		
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		
		if(row1 > row2 || col1 > col2 || sum.length == 0|| sum[0].length == 0){
			return 0;
		}

		int res = sum[row2][col2];
		
		if(row1 != 0){
			res -= sum[row1-1][col2];
		}
		if(col1 != 0){
			res -= sum[row2][col1-1];
		}
		if(row1 != 0 && col1 != 0){
			res += sum[row1-1][col1-1];
		}

		return res;
		
	}
	
	public static void main(String[] args) {
		int [][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},{1, 2, 0, 1, 5}};
		Q304 q = new Q304(matrix);
		System.out.println(q.sumRegion(1, 1, 2, 2));
		
	}

}
