package com.dy.leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class Q310 {
	public static class Node implements Comparable<Node> {
		int value;
		HashSet<Integer> next;

		Node(int value) {
			this.value = value;
			next = new HashSet<Integer>();
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.value,this.next);
		}
		

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.next.size(), o.next.size());
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (this.getClass() != obj.getClass())
				return false;

			Node i = (Node) obj;
			return Objects.equals(this.next, i.next)
					&& this.value == i.value;
		}
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
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
		System.out.println("map.values().size()=" + map.values().size());
//		TreeSet<Node> treeSet = new TreeSet<Node>(map.values());
		//有的节点添加不进去，明明重写hashcode和equal啊！！！！
		TreeSet<Node> treeSet = new TreeSet<Node>();
		for (Node node : map.values()) {
			if(treeSet.contains(node)){
				System.out.println("contains->"+node);
			}
			treeSet.add(node);
		}
		for (Node node : treeSet) {
			System.out.println("value= " + node.value + ",next.size="
					+ node.next.size());
		}
		return null;
	}

	public static void main(String[] args) {
		Q310 q = new Q310();
		int[][] edges = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		q.findMinHeightTrees(6, edges);
		
	}
}
