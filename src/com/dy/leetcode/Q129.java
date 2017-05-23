package com.dy.leetcode;

import java.util.LinkedList;

public class Q129 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = cal(root, new LinkedList<TreeNode>());
		return sum;
	}

	public int cal(TreeNode cur, LinkedList<TreeNode> list) {
		list.add(cur);
		if (cur.left == null && cur.right == null) {
			StringBuffer sb = new StringBuffer();
			for (TreeNode node : list) {
				sb.append(node.val+"");
			}
			list.remove(list.size() - 1);
			return Integer.valueOf(sb.toString());
		}else {
		
			int sum = 0;
			if(cur.left != null){
				sum += cal(cur.left, list);
			}
			if(cur.right != null){
				sum += cal(cur.right, list);
			}
			list.remove(list.size() - 1);
			return sum;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(5);
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t3.right = t4;
		Q129 q = new Q129();
		int x = q.sumNumbers(root);
		System.out.println(x);
		
	}

}
