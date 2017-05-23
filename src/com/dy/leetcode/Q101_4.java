package com.dy.leetcode;

import java.util.LinkedList;

public class Q101_4 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	public static boolean isSymmetric(TreeNode left, TreeNode right) {
		//左右队列分别进行判断
		LinkedList<TreeNode> rlist = new LinkedList<TreeNode>();
		LinkedList<TreeNode> llist = new LinkedList<TreeNode>();
		rlist.offer(right);
		llist.offer(left);
		TreeNode lNode, rNode;
		while (!rlist.isEmpty() && !llist.isEmpty()) {
			lNode = llist.poll();
			rNode = rlist.poll();
			if(lNode == null && rNode == null){
				continue;
			}else if(lNode != null && rNode != null){
				if(lNode.val != rNode.val){
					return false;
				}else{
					//注意进入队列的顺序和位置
					llist.offer(lNode.left);
					rlist.offer(rNode.right);
					
					llist.offer(lNode.right);
					rlist.offer(rNode.left);
				}
			}else{
				return false;
			}
		}
		
		return true;

	}

	public static boolean isSymmetric(TreeNode root) {
		//使用两个队列进行遍历
		if(root == null){
			return true;
		}else{
			return isSymmetric(root.left,root.right);
		}

		
	}

	public static void main(String[] args) {
		// [3,4,4,5,null,null,5,6,null,null,6]
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
		//t5.right = t7;
		// 3445**56**6****
		System.out.println(isSymmetric(root));
	}
}
