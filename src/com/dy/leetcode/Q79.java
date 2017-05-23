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
		// �ڸ�����Ƿ��ҵ��յ�
		boolean b = false;
		for (node n : list) {
			node cur = n;
			// ����Χ�Ƿ��ҵ��ַ�w[j]
			boolean t = false;
			List<node> path = new ArrayList<node>();
			for (int j = 1; j < w.length; j++) {
				// ��Χ��
				for (int i = 0; i < y.length; i++) {
					int curx = cur.x + x[i];
					int cury = cur.y + y[i];
					if (curx >= 0 && curx < c.length && cury >= 0
							&& cury < c[0].length && c[curx][cury] == w[j]) {
						// ��ֹ�ڵ��ظ���{"aa"},"aaaa"
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
					// ���ã�����һ��
					t = false;
					if (j == w.length - 1) {
						b = true;
					}
					continue;
				}
			}
			if (!b) {
				// ���ã�����һ�����
				b = false;
				System.out.println(path);
				path = new ArrayList<node>();

			} else {
				// �ҵ������з���
				return b;
			}

		}

		System.out.println("B" + b);
		// �ұ����У���û��
		return b;
	}

	public static void main(String[] args) {
		// char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'C', 'C', 'S' },
		// { 'A', 'D', 'E', 'E' } };
		// String word = "ABCCED";
		//�ظ�û�н��
		char[][] board = { { 'a', 'a' } };
		String word = "aaa";
		Q79 q = new Q79();
		boolean b = q.exist(board, word);
		System.out.println(b);
	}

}
