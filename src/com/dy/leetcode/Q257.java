package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Q257 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	//������ͼ��dfs
	//visit�൱��boolean�ж��Ƿ���ʹ���stack��ջ������������¼����˳��
	public static void dfs(TreeNode root,ArrayList<TreeNode> visit,Stack<TreeNode> stack,List<String> list){
		visit.add(root);
		stack.push(root);
		//System.out.println(root.val);
		if(root.left != null){
			if(!visit.contains(root.left)){
				dfs(root.left,visit,stack,list);
			}
		}
		if(root.right != null){
			if(!visit.contains(root.right)){
				dfs(root.right,visit,stack,list);
			}
		}
		if(root.left == null && root.right == null){
			//Ҷ�ӽڵ�
//			System.out.println("=start=");
			String s = "";
			//ȥ����һ��-��
			int cnt = 1;
			for (TreeNode treeNode : stack) {
//				System.out.println(treeNode.val);
				if(cnt != 1){
					s += "->";
				}
				s += treeNode.val;
				cnt++;
			}
			
			list.add(s);
//			System.out.println("=end=");
		}
		stack.pop();
		
		
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if(root == null){
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		ArrayList<TreeNode> map = new ArrayList<TreeNode>();
		dfs(root, map, stack, list);
		return list;
	}
	
	public static void main(String[] args) {
		ArrayList<TreeNode> map = new ArrayList<TreeNode>();
		TreeNode root = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		root.left = t2;
		root.right = t3;
		t3.left = t4;
		t2.right = t5;
		t4.left = t6;
		t2.left = t7;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<String> list = new ArrayList<String>();
		dfs(root, map,stack,list);
		System.out.println(list.size());
	}

}
