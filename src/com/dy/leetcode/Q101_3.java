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
			//����Ҫ�ж�������һ���Գ�
			return true;
		}else if(left != null && right != null ){
			if(left.val != right.val){
				//һ�����Գƣ���Ҫ��Ҫ�ж�����
				return false;
			}
		}else{
			return false;
		}
		//���������Һ�����������Աȣ�������������������
		return isSymmetric(right.right, left.left) & isSymmetric(right.left, left.right);
		
	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}else{
			//�ж����������Ƿ�Գ�
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
