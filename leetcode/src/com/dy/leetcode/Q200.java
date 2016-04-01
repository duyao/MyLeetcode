package com.dy.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q200 {
	public int numIslands(char[][] grid) {
		int cnt = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1'){
					cnt++;
					travel(grid,i,j);
				}
			}
		}
		return cnt;

	}
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public void travel(char[][] grid, int a, int b){
		Deque<Node> queue = new LinkedList<Node>();
		queue.add(new Node(a, b));
		grid[a][b] = '0';
		int[] x = {0, 0, 1, -1};
		int[] y = {1, -1, 0, 0};
		while(!queue.isEmpty()){
			Node cur = queue.poll();
			for (int i = 0; i < y.length; i++) {
				int curX = cur.x + x[i];
				int curY = cur.y + y[i];
				if(curX >= 0 && curX < grid.length && curY >= 0 && curY < grid[0].length && grid[curX][curY] == '1'){
					grid[curX][curY] = '0';
					queue.add(new Node(curX, curY));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Q200 q = new Q200();
		int[][] r = {{1,1,1,1,0}};
		char[][] grid = new char[r.length][r[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = Integer.toString(r[i][j]).charAt(0);
			}
		}
		int x = q.numIslands(grid);
		System.out.println(x);
	}

}
