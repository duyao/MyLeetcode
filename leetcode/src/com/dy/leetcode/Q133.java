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

	// dfs���Ƿ���ʹ��ı��
	static HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}

		if (map.containsKey(node.label)) {
			return map.get(node.label);
		}

		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		//�������Ľڵ�һ����clone
		//��Ϊ����Ŀ��cloneͼ���ݹ鷵�ص�ֵ�Ǵ�map�л�ȡ������ȡ����ֵ������һ���½ڵ�
		//map.put(node.label, node);
		map.put(clone.label, clone);
		for (UndirectedGraphNode next : node.neighbors) {
			
			//����������ڽӵ�������¹���Ľڵ㣬������ԭ����
			//clone.neighbors.add(next);
			//�ݹ�ķ���ֵ���µĽ��
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
