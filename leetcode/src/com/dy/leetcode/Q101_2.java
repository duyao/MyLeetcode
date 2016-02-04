package com.dy.leetcode;




public class Q101_2 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	//中序遍历不能
	//[1,2,3,3,null,2,null]
	public static String travel(TreeNode root){
		
		if(root != null){
			return  ""+travel(root.left)+root.val+travel(root.right);
		}else{
			return "";
		}
	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}else{
			String s = travel(root);
			int i = 0;
			int j = s.length() - 1;
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
//		root.left = t2;
		root.right = t3;
//		t3.left = t4;
//		t2.right = t5;
//		t4.left = t6;
//		t5.right = t7;
		//3445**56**6****
		System.out.println(isSymmetric(root));
	}
}
