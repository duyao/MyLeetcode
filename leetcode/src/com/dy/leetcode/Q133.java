package com.dy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q133 {
	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	// dfs中是否访问过的标记
	static HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}

		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		//这里放入的节点一定是clone
		//因为本题目是clone图，递归返回的值是从map中获取，而获取到的值必须是一个新节点
		//map.put(node.label, node);
		map.put(clone.label, clone);
		for (UndirectedGraphNode next : node.neighbors) {
			
			//这里添加相邻接点必须是新构造的节点，而不是原来的
			//clone.neighbors.add(next);
			//递归的返回值是新的结点
			clone.neighbors.add(cloneGraph(next));
		}
		return clone;

	}

	public static void main(String[] args) {
		UndirectedGraphNode root = new UndirectedGraphNode(1);
		UndirectedGraphNode n1 = new UndirectedGraphNode(2);
//		UndirectedGraphNode n2 = new UndirectedGraphNode(3);
		root.neighbors.add(n1);
//		n1.neighbors.add(n2);
//		n1.neighbors.add(root);
//		n2.neighbors.add(n1);
//		root.neighbors.add(root);
		
		UndirectedGraphNode clone = cloneGraph(root);
		System.out.println(clone.neighbors.size());
	}

}
