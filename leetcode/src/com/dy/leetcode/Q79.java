package com.dy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q79 {
	static class node {
		int x, y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public boolean exist(char[][] board, String word) {
		
		if (word == null || board == null) {
			return false;
		}
		HashMap<Character, List<node>> map = new HashMap<Character, List<node>>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				List<node> list = new ArrayList<node>();
				if (map.containsKey(board[i][j])) {
					list = map.get(board[i][j]);
				}
				list.add(new node(i, j));
				map.put(board[i][j], list);
			}
		}
		return f(board, map, word.toCharArray());

	}

	public boolean f(char[][] c, HashMap<Character, List<node>> map, char[] w) {

		int[] x = { 0, 0, 1, -1 };
		int[] y = { 1, -1, 0, 0 };
		List<node> list = map.get(w[0]);
		if (list == null) {
			return false;
		}
		if (w.length == 1) {
			return true;
		}
		// 在该起点是否找到终点
		boolean b = false;
		for (node n : list) {
			node cur = n;
			// 在周围是否找到字符w[j]
			boolean t = false;
			List<node> path = new ArrayList<Q79.node>();
			for (int j = 1; j < w.length; j++) {
				// 周围找
				for (int i = 0; i < y.length; i++) {
					int curx = cur.x + x[i];
					int cury = cur.y + y[i];
					if (curx >= 0 && curx < c.length && cury >= 0
							&& cury < c[0].length && c[curx][cury] == w[j]) {
						// 防止节点重复，{"aa"},"aaaa"
						// if(visit.isEmpty() || visit.contains(o))
						t = true;
						cur = new node(curx, cury);
						path.add(cur);
						System.out.println(curx + "," + cury);
						break;

					}
				}
				if (!t) {
					b = false;
					break;
				} else {
					// 重置，找下一周
					t = false;
					if (j == w.length - 1) {
						b = true;
					}
					continue;
				}
			}
			if (!b) {
				// 重置，找下一个起点
				b = false;
				System.out.println(path);
				path = new ArrayList<Q79.node>();

			} else {
				// 找到了所有返回
				return b;
			}

		}

		System.out.println("B" + b);
		// 找遍所有，都没有
		return b;
	}

	public static void main(String[] args) {
		// char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'C', 'C', 'S' },
		// { 'A', 'D', 'E', 'E' } };
		// String word = "ABCCED";
		//重复没有解决
		char[][] board = { { 'a', 'a' } };
		String word = "aaa";
		Q79 q = new Q79();
		boolean b = q.exist(board, word);
		System.out.println(b);
	}

}
