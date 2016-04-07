package com.dy.leetcode;

public class Q129_1 {
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
		int sum = cal(root, new StringBuffer());
		return sum;
	}

	public int cal(TreeNode cur, StringBuffer sb) {
		
		sb.append(cur.val);
		if (cur.left == null && cur.right == null) {
			int tmp = Integer.valueOf(sb.toString());
			sb.deleteCharAt(sb.length()-1);
			return tmp;
		} else {

			int sum = 0;
			if (cur.left != null) {
				sum += cal(cur.left, sb);
			}
			if (cur.right != null) {
				sum += cal(cur.right, sb);
			}
			sb.deleteCharAt(sb.length()-1);
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
		Q129_1 q = new Q129_1();
		int x = q.sumNumbers(root);
		System.out.println(x);

	}

}
