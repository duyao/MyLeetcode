package com.dy.leetcode;

import com.dy.leetcode.Q116.TreeLinkNode;

public class Q117 {
	//类似于bfs
	public void connect(TreeLinkNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		//next可以替代队列的作用
		TreeLinkNode cur = root;
		TreeLinkNode head = root.left == null ? root.right : root.left;
		while (cur != null) {
			if (cur == head) {
				if (cur.left != null) {
					head = cur.left;
				} else if (cur.right != null) {
					head = cur.right;
				} else {
					head = getNext(cur);
				}
			}

			if (cur.left != null) {
				cur.left.next = cur.right == null ? getNext(cur) : cur.right;
			}
			if (cur.right != null) {
				cur.right.next = getNext(cur);
			}
			if (cur.next == null) {
				cur = head;
			} else {
				cur = cur.next;
			}

		}
	}

	public TreeLinkNode getNext(TreeLinkNode root) {
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

}
