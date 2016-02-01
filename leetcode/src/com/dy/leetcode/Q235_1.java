package com.dy.leetcode;

import java.util.ArrayList;

public class Q235_1 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			this.val = value;
		}
	}

	public static void travle(TreeNode root, TreeNode p, TreeNode q,
			ArrayList<TreeNode> list) {

		if (root != null) {
			// 只有介于两者之间的值才加入队列
			if (root.val >= p.val && root.val <= q.val) {
				list.add(root);
			}

			// 遍历所有的值，不能选择，否则会出错，在加入时选择
			travle(root.left, p, q, list);
			travle(root.right, p, q, list);

		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		if (q.val == p.val) {
			return q;
		}
		TreeNode small = p.val < q.val ? p : q;
		TreeNode big = p.val < q.val ? q : p;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		travle(root, small, big, list);
		if (list.size() == 0) {
			return big;
		} else {
			return list.get(0);
		}

	}

	public static void main(String[] args) {
		// [5,3,6,2,4,null,null,1]
		TreeNode root = new TreeNode(5);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(1);
		root.left = t2;
		root.right = t3;
		t2.left = t4;
		t2.right = t5;
		t4.left = t6;
		TreeNode res = lowestCommonAncestor(root, t5, t4);
		System.out.println(res.val);

	}

}
