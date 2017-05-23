package com.dy.leetcode;

public class Q226 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	// 与遍历相同
	public TreeNode invertTree(TreeNode root) {
		if (root != null) {

			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;

			if (root.left != null) {
				invertTree(root.left);
			}
			if (root.right != null) {
				invertTree(root.right);
			}

			

//			invertTree(root.left);
//			invertTree(root.right);
//			TreeNode tmp = root.left;
//			root.left = root.right;
//			root.right = tmp;
		}

		return root;

	}
}
