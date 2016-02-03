package com.dy.leetcode;

import java.util.LinkedList;



public class Q101 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	// public boolean isSymmetric(TreeNode root) {
	// if (root == null) {
	// return true;
	// }
	// boolean b = false;
	// if(root.left != null && root.right != null) {
	// if (root.left.val == root.right.val) {
	// b = true;
	// } else {
	// b = false;
	// }
	// } else if (root.left == null && root.right == null) {
	// b = true;
	// }else{
	// b = false;
	// }
	//
	// return b && isSymmetric(root.left) && isSymmetric(root.right);
	//
	// }

	// 层次遍历
	public static String travel(TreeNode root) {
		String s = "";
		if (root != null) {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(root);
			TreeNode cur = new TreeNode(0);
			while (!list.isEmpty()) {
				cur = list.poll();
				if (cur == null) {
					s += "*";
				} else {
					s += cur.val;
					list.offer(cur.left);
					list.offer(cur.right);
				}
			}

		}
		return s;
	}

	public static boolean f(String s, int i, int j) {
		// 0,1 2,3 4 5 6,

		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		String s = travel(root);
		//每一层的个数
		int cnt = 1;
		//起始点
		int i = 0;
		int j = 0;
		boolean b = true;
		while (i < s.length()) {
			j = j > s.length() ? s.length()-1 : j;
			b &= f(s,i,j);
			if(!b){
				return false;
			}
			// 0,1 2,3 4 5 6,
			cnt *= 2;
			i = j + 1;
			j = i + cnt - 1;
		}
		return true;
	}
	
	public static void main(String[] args) {
		//[3,4,4,5,null,null,5,6,null,null,6]
		TreeNode root = new TreeNode(3);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(6);
		root.left = t2;
		root.right = t3;
		t2.left = t4;
		t3.right = t5;
		t4.left = t6;
		t5.right = t7;
		//3445**56**6****
		System.out.println(isSymmetric(root));
	}
}
