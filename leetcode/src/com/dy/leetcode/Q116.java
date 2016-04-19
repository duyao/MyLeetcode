package com.dy.leetcode;


public class Q116 {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root != null) {
			travel(root);

		}
	}

	public void travel(TreeLinkNode root) {
		if (root.left != null) {
			root.left.next = root.right;
			if (root.next != null) {
				root.right.next = root.next.left;
			}
			travel(root.left);
			travel(root.right);
		}
	}

	public static void main(String[] args) {
		int x = 10;
		if(x  > 3){
			System.out.println("x > 5");
		}else if(x > 5){
			System.out.println("x > 3");
		}
	}

}
