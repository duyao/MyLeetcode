package com.dy.leetcode;

public class Q289 {
	public void gameOfLife(int[][] board) {
		//1->0 == 2
		//0->1 == -1
		//使用假色，1的个数=大于零的个数，因为可能有1->0 == 2
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				int k = f(board, i , j);
				if(board[i][j] == 1 && (k < 2 || k > 3)){
					//1->0 == 2
					board[i][j] = 2;
				}else if(board[i][j] == 0 && k == 3){
					//0->1 == -1
					board[i][j] = -1;
				}
			}
		}
		//恢复
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == 2){
					//1->0 == 2
					board[i][j] = 0;
				}else if(board[i][j] == -1){
					//0->1 == -1
					board[i][j] = 1;
				}
			}
		}
		

	}
	//计算个数
	public int f(int[][] x, int a, int b){
		int cnt = 0;
		int[] k = {-1, 0, 1};
		for(int i = 0; i < 3; i++){
			int curi = a + k[i];
			for(int j = 0; j < 3; j++){
				int curj = b + k[j];
				if(curi >= 0 && curj >= 0 && curi < x.length && curj < x[0].length 
						&& x[curi][curj] > 0 && !(k[i] == 0 && k[j] == 0)){
					cnt++;
				}
			}
		}
		return cnt;
	}

	
}
