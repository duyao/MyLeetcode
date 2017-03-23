package com.dy.leetcode;
import java.util.LinkedList;


//The algorithm is quite simple: Use BFS starting from 'O's on the boundary and mark them as 'B', 
//then iterate over the whole board and mark 'O' as 'X' and 'B' as 'O'
public class Q130 {
	static class Node{
		int x;
		int y;
		//记录坐标信息，不需要设置访问值，因为被访问后的值会被改变
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	//只访问边界的坐标，将边界坐标o置为b，且其相邻的o也遍历置为b
	public void bfsBoundary(char[][] c, int x, int y,boolean[][] in){
		int len = c[0].length;
		int wid = c.length;
		int[] xx = {0, 1, 0, -1};
		int[] yy = {-1, 0, 1, 0};
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(new Node(x, y));
		c[x][y] = 'b';
//		in[x][y] =true;
		while(!queue.isEmpty()){
			Node cur = queue.poll();
//			c[cur.x][cur.y] = 'b';
			for(int i = 0; i < xx.length; i++){
				int curX = cur.x + xx[i];
				int curY = cur.y + yy[i];
//				&& !in[curX][curY]
				if( curX >= 0 && curX < wid && curY >= 0 && curY < len && c[curX][curY] == 'O' ){
					queue.add(new Node(curX, curY));
//					in[curX][curY] = true;
					c[curX][curY] = 'b';
				}
			}
		}
		
	}
	public void solve(char[][] board) {

		if(board == null || board.length == 0){
			return;
		}
		
		boolean[][] in = new boolean[board.length][board[0].length];
		int len = board[0].length;
		int wid = board.length;
		//访问边缘
		for(int i = 0; i <len; i++){
			if(board[0][i] == 'O'){
				bfsBoundary(board, 0, i, in);
			}
			if(board[wid-1][i] == 'O'){
				bfsBoundary(board, wid-1, i, in);
			}
		}
		for(int i = 0; i < wid; i++){
			if(board[i][0] == 'O'){
				bfsBoundary(board, i, 0, in);
			}
			if(board[i][len-1] == 'O'){
				bfsBoundary(board, i, len-1, in);
			}
		}
		//顺序访问
		for(int i = 0; i < wid; i++){
			for(int j = 0; j < len; j++){
				if(board[i][j] == 'b'){
					board[i][j] = 'O';
				}
				else if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
			}
		}
		

	}
	
	public static void main(String[] args) {
		String[] s= {"XOOXXXOXOO","XOXXXXXXXX","XXXXOXXXXX","XOXXXOXXXO","OXXXOXOXOX","XXOXXOOXXX","OXXOOXOXXO","OXXXXXOXXX","XOOXXOXXOO","XXXOOXOXXO"};
		char[][] c = new char[s[0].length()][s.length];
		for(int i = 0; i < s.length; i++){
			for(int j = 0; j < s[0].length(); j++){
				c[i][j] = s[i].charAt(j);
			}
		}
		for(int i = 0; i < c.length; i++){
			for(int j = 0; j < c[0].length; j++){
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
		System.out.println("===================================");
		Q130 q = new Q130();
		q.solve(c);
		for(int i = 0; i < c.length; i++){
			for(int j = 0; j < c[0].length; j++){
				System.out.print(c[i][j]);
			}
			System.out.println();
		}
	}

}
