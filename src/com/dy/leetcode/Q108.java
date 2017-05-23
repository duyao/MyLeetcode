package com.dy.leetcode;

public class Q108 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0){
			return null;
		}
		TreeNode root = build(nums, 0, nums.length - 1);
		return root;

	}

	public TreeNode build(int[] nums, int i, int j) {
		if (i <= j) {
			int m = (i + j) / 2;
			TreeNode cur = new TreeNode(nums[m]);

			cur.left = build(nums, i, m - 1);
			cur.right = build(nums, m + 1, j);

			return cur;
		} else {
			return null;
		}

	}

	public void printTree(TreeNode root) {
		
		if (root != null) {
			printTree(root.left);
			System.out.print(root.val + " ");
			printTree(root.right);
		}
		
		
	}

	public static void main(String[] args) {
		Q108 q = new Q108();
		int[] nums = { 1, 2, 3, 4, 5 };
		TreeNode root = q.sortedArrayToBST(nums);
		 q.printTree(root);
	}

}
