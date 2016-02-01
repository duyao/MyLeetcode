package com.dy.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Q235 {
	public static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		public TreeNode(int value) {
			this.value = value;
		}
	}
	
	public static void travle(TreeNode root, HashMap<TreeNode, TreeNode> map){
		if(root != null){
			if(root.left != null){
				map.put(root.left, root);
			}
			if(root.right != null){
				map.put(root.right, root);
			}
			
			travle(root.left, map);
			travle(root.right, map);
		}
	}
	
	public static ArrayList<TreeNode> getParents(HashMap<TreeNode, TreeNode> map, TreeNode root ){
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		while(root != null){
			root = map.get(root);
			if(root != null){
				list.add(root );
			}
		}
		return list;
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//key是当前结点,value是父节点
		HashMap<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
		travle(root, map);
		map.put(root, null);
		
		ArrayList<TreeNode> pNode = getParents(map, p);
		ArrayList<TreeNode> qNode = getParents(map, q);
		
		for (TreeNode treeNode : qNode) {
			if(treeNode == p){
				return p;
			}
		}
		for (TreeNode treeNode : pNode) {
			if(treeNode == q){
				return q;
			}
		}
		
		
		for (TreeNode qtreeNode : qNode) {
			for (TreeNode ptreeNode : pNode) {
				if(qtreeNode == ptreeNode){
					return qtreeNode;
				}
			}
		}
		
		return null;
		
		
		
		
	}
	
	public static void main(String[] args) {
//		[5,3,6,2,4,null,null,1]
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
		TreeNode res = lowestCommonAncestor(root, t3, t6);
		System.out.println(res.value);
		
		
		
	}

}
