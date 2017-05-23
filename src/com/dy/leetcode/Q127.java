package com.dy.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
//tle
//找邻居的时候三次循环，wordList*wordList*单词长度
public class Q127 {
	public class Node {
		String value;
		HashSet<Node> next;

		public Node(String s) {
			this.value = s;
			next = new HashSet<Node>();
		}
	}

	public static boolean isSame(String a, String b) {
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		int cnt = 0;
		for (int i = 0; i < bb.length; i++) {
			if (aa[i] != bb[i]) {
				cnt++;
			}
			if (cnt > 1) {
				return false;
			}
		}
		if (cnt == 1) {
			return true;
		} else {
			return false;
		}
	}

	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		if(wordList == null || wordList.size() == 0){
			return 0;
		}
		// 建立图
		Node begin = new Node(beginWord);
		Node end = new Node(endWord);
		Set<Node> nodes = new HashSet<Node>();
		for (String s : wordList) {
			Node n = new Node(s);
			nodes.add(n);
		}

		for (Node node : nodes) {
			if (isSame(begin.value, node.value)) {
				node.next.add(begin);
				begin.next.add(node);
			}
			if (isSame(end.value, node.value)) {
				node.next.add(end);
				end.next.add(node);
			}
			for (Node nn : nodes) {
				if (nn != node && isSame(nn.value, node.value)) {
					nn.next.add(node);
					node.next.add(nn);
				}
			}
		}

		// bfs
		LinkedList<Node> queue = new LinkedList<Node>();
		HashSet<Node> vis = new HashSet<Node>();
		queue.offer(begin);
		int cnt = 0;
		Node tail = begin;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			vis.add(cur);
			if (cur == end) {
				return cnt + 1;
			}
			for (Node node : cur.next) {
				if (!vis.contains(node)) {
					queue.offer(node);

				}
			}
			if (cur == tail) {
				cnt++;
				if(queue.isEmpty()){
					return 0;
				}
				tail = queue.getLast();
			}

		}
		return 0;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log" };
		Set<String>	set = new HashSet<String>();
		for (String s : wordList) {
			set.add(s);
		}
		Q127 q = new Q127();
		int x = q.ladderLength(beginWord, endWord, set);
		System.out.println(x);
		
	}
}
