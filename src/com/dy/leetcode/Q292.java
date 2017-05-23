package com.dy.leetcode;

import java.util.ArrayList;

class Node {
	Node dad;
	int value;
	int layer;
	boolean isLeaf;
	int curSum;

	public Node(int value) {
		this.dad = null;
		this.value = value;
		this.isLeaf = true;
		this.curSum = value;
		this.layer = 1;
	}
}

public class Q292 {
	// ʹ�������ڲ��鼯�ķ�ʽ��¼���ڵ�
	// ����һ���ṹ�������Ƿ���Ҷ�ӣ�ֵ��id
	// ����ÿ�����룬�������νṹ��ԭ�������ڱ�������;�����������ܾͼ�������
	// ������һ�����󣬱���ÿ��Ҷ�ӽڵ㣬���н�����ڵĲ�����ͬ��Ϊ��������win������lose
	public static void create(int value, int total, ArrayList<Node> nodes,
			Node dad) {
		Node n = new Node(value);
		if (dad != null) {
			n.dad = dad;
			n.layer = dad.layer + 1;
			n.curSum += dad.curSum;
		}
		nodes.add(n);

		if (total - n.curSum > 3) {
			create(3, total, nodes, n);
			create(2, total, nodes, n);
			create(1, total, nodes, n);

			n.isLeaf = false;
		} else {
			if (total - n.curSum > 0) {
				create(total - n.curSum, total, nodes, n);
				n.isLeaf = false;
			}
		}
	}

	// �Ƿ�һ������win
	public static boolean isWin(ArrayList<Node> nodes) {
		int height = -1;
		for (Node node : nodes) {
			if (node.isLeaf) {
				height = height == -1 ? node.layer : height;
				if (height != node.layer) {
					return false;
				}
			}
		}
		if (height % 2 == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean canWinNim1(int n) {
		if (n <= 3) {
			return true;
		}
		int len = n - 3 > 3 ? 3 : n - 3;
		for (int i = len; i > 0; i--) {
			// �γ�node���飬���ڱ���
			ArrayList<Node> nodes = new ArrayList<Node>();
			create(i, n, nodes, null);
			if (isWin(nodes)) {
				return true;
			}
		}
		return false;

	}

	
	
	//https://leetcode.com/discuss/63978/one-line-o-1-solution-and-explanation
	public static boolean canWinNim2(int n) {
		if ((n % 4) != 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		
		for (int i = 1; i < 21; i++) {
			System.out.println(i + ": " + canWinNim1(i));
			System.out.println("a: " + canWinNim2(i));
		}

	}
}
