package com.dy.leetcode;

public class Q100 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static String travel(TreeNode root) {
		if (root == null) {
			return "*";
		}

		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(root.val);
		sBuffer.append(travel(root.left));
		sBuffer.append(travel(root.right));
		//此处不用判断子树是否为空，因为继续走下去，传入空树直接返回，与sBuffer.append(travel(root.left))相同
//		if (root.left == null) {
//			sBuffer.append("*");
//		} else {
//			sBuffer.append(travel(root.left));
//		}
//
//		if (root.right == null) {
//			sBuffer.append("*");
//		} else {
//			sBuffer.append(travel(root.right));
//		}
		return sBuffer.toString();
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		String pString = travel(p);
		String qString = travel(q);
		System.out.println("pString"+pString);
		System.out.println("qString"+qString);
		if (qString.equals(pString)) {
			return true;
		} else {
			return false;
		}
	}

	
	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		TreeNode node = new TreeNode(2);
		p.left = null;
		p.right = node;
		
		TreeNode q = new TreeNode(1);
		q.left = node;
		q.right = null;
		
		Q100 s1 = new Q100();
		System.out.println(s1.isSameTree(p, q));
		
		
		
	}

}
