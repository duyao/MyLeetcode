package com.dy.leetcode;

public class Q230 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int kthSmallest(TreeNode root, int k) {
		int cnt = vis(root.left);
		if(k == cnt+1){
			return root.val;
		}else if(k < cnt+1){
			return kthSmallest(root.left, k);
		}else{
			return kthSmallest(root.right, k - cnt - 1);
		}
		
	}

	public int vis(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return vis(root.left) + vis(root.right) + 1;
	}

}
