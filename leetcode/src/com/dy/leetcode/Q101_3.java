package com.dy.leetcode;




public class Q101_3 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null){
			//不需要判断子树，一定对称
			return true;
		}else if(left != null && right != null ){
			if(left.val != right.val){
				//一定不对称，不要需要判断子树
				return false;
			}
		}else{
			return false;
		}
		//左子树的右和右子树的左对比，这里左右子树都存在
		return isSymmetric(right.right, left.left) & isSymmetric(right.left, left.right);
		
	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}else{
			//判断左右子树是否对称
			return isSymmetric(root.left, root.right);
		}
		
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
		t3.left = t4;
		t2.right = t5;
		t4.left = t6;
		t5.right = t7;
		//3445**56**6****
		System.out.println(isSymmetric(root));
	}
}
