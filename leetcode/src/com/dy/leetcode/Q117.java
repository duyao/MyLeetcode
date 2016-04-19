package com.dy.leetcode;

import com.dy.leetcode.Q116.TreeLinkNode;

public class Q117 {
	public void connect(TreeLinkNode root) {
		if(root == null  || (root.left ==null && root.right == null)){
			return;
		}
		TreeLinkNode tail = root;
		TreeLinkNode cur = root;
		TreeLinkNode head = root.left == null? root.right : root.left;
		while(cur != null){
			if(cur.left != null){
				cur.left.next = cur.right==null? getNext(cur):cur.right;
			}
			if(cur.right != null){
				cur.left.next = getNext(cur);
			}
			if(cur == head){
				tail = 
			}
			
		}
	}
	public TreeLinkNode getNext(TreeLinkNode root){
		TreeLinkNode tmp = root.next;
		while (tmp != null) {
			if (tmp.left != null) {
				return tmp.left;
			} else if (tmp.right != null) {
				return tmp.right;
			}
			tmp = tmp.next;
		}
		return null;
	}

	public void travel(TreeLinkNode root) {
		if(root == null){
			return ;
		}
		if (root.left != null && root.right != null) {
			root.left.next = root.right;
			TreeLinkNode tmp = root.next;
			while (tmp != null) {
				if (tmp.left != null) {
					root.right.next = tmp.left;
					break;
				} else if (tmp.right != null) {
					root.right.next = tmp.right;
					break;
				}
				tmp = tmp.next;
			}

		} else if (root.left != null || root.right == null) {
			TreeLinkNode tmp = root.next;
			while (tmp != null) {
				if (tmp.left != null) {
					root.left.next = tmp.left;
					break;
				} else if (tmp.right != null) {
					root.left.next = tmp.right;
					break;
				}
				tmp = tmp.next;
			}

		}else if(root.right != null && root.left == null){
			TreeLinkNode tmp = root.next;
			while (tmp != null) {
				if (tmp.left != null) {
					root.right.next = tmp.left;
					break;
				} else if (tmp.right != null) {
					root.right.next = tmp.right;
					break;
				}
				tmp = tmp.next;
			}
		}
		travel(root.left);
		travel(root.right);
	}

}
