package com.dy.leetcode;

public class Q104 {
	public class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}
	}

	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
	}
}
