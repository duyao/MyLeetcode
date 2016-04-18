package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Q310_1 {

	public static class Node implements Comparable<Node> {
		int value;
		HashSet<Integer> next;

		Node(int value) {
			this.value = value;
			next = new HashSet<Integer>();
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.next.size(), o.next.size());
		}

	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n == 0) {
			return res;
		} else if (n == 1) {
			res.add(0);
			return res;
		}
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[0].length; j++) {
				if (!map.containsKey(edges[i][j])) {
					Node tmp = new Node(edges[i][j]);
					map.put(edges[i][j], tmp);
				}
				Node node = map.get(edges[i][j]);
				int tmp = j == 0 ? edges[i][j + 1] : edges[i][j - 1];
				node.next.add(tmp);
			}
		}
		ArrayList<Node> list = new ArrayList<Node>(map.values());
		Collections.sort(list);
		// for (Node node : list) {
		// System.out.println("value= " + node.value + ",next.size="
		// + node.next.size());
		// }

		if (list.size() > 2) {

			Deque<Node> visit = new LinkedList<Node>();
			int curLevel = list.get(0).next.size();
			for (Node node : list) {
				if (curLevel == node.next.size()) {
					visit.add(node);
				} else {
					break;
				}
			}
			for (Node node : visit) {
				System.out.print(node.value+" ");
			}
			Node tail = visit.getLast();
			int cnt = 0;
			while (!visit.isEmpty()) {
				Node node = visit.poll();
				cnt++;
				for (Integer value : node.next) {
					Node tmp = map.get(value);
					tmp.next.remove(node.value);
					//对于vis的更新策略不是邻居就遍历，而是每次挑选只有1条邻边的遍历
					if (!visit.contains(tmp)) {
						visit.add(tmp);
					}
				}
				if (tail == node) {
					if ((visit.size() ==2 && cnt+visit.size() == list.size())|| visit.size() == 1) {
						break;
					} else {
						tail = visit.getLast();
					}
				}
			}
			for (Node node : visit) {
				res.add(node.value);
			}
		}else{
			for (Node node : list) {
				res.add(node.value);
			}
		}

		
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		Q310_1 q = new Q310_1();
		 //case not pass 
		int n = 12;
		int[][] edges = { {0,1},{0,2},{0,3},{3,4},{3,5},{1,6},{4,7},{2,8},{0,9},{0,10},{2,11}};
//		 int n = 4;
//		 int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
//		int n = 6;
//		int[][] edges = { {0,1},{0,2},{0,3},{3,4},{4,5} };
//		q.findMinHeightTrees(n, edges);
		Q310_2 qq = new Q310_2();
		List<Integer> res =qq.findMinHeightTrees(n, edges);
		System.out.println(res);
	}
}
