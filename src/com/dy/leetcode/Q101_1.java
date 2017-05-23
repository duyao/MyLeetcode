package com.dy.leetcode;

import java.util.LinkedList;



public class Q101_1 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

	// 层次遍历
	public static boolean travel(TreeNode root,int tall) {
		String s = "";
		int height = 0;
	
		if (root != null) {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(root);
			TreeNode cur = new TreeNode(0);
			TreeNode last = root;
			while (!list.isEmpty() && height != tall) {
				cur = list.poll();
				
				if (cur.val == Integer.MAX_VALUE) {
					
						s += "*";
					
				} else {
					s += cur.val;
					//空节点会是层数出错，因此要变化
					//空节点设置为值最大的节点
					if(cur.left == null){
						list.offer(new TreeNode(Integer.MAX_VALUE));
					}else{
						list.offer(cur.left);

					}
					if(cur.right == null){
						list.offer(new TreeNode(Integer.MAX_VALUE));
					}else{
						list.offer(cur.right);

					}
				}
				
				if(cur == last){
					last = list.getLast();
					height++;
					System.out.println(s+f(s));
					if(!f(s)){
						return false;
					}
					s = "";
				}
				
				
				
			}

		}
//		System.out.println("height = "+height);
		return true;
	}

	public static boolean f(String s) {
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
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		}
		
		return travel(root,getTall(root));
		
	}
	
	public static int getTall(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(getTall(root.left), getTall(root.right)) + 1;
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
