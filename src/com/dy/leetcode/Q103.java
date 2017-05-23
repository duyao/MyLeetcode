package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.dy.leetcode.Q129.TreeNode;

public class Q103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null){
			return res;
		}
		int curh = 1;
		// double ended queue
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode head = root, tail = null;
		List<Integer> path = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode cur = queue.peek();
			if (cur == head) {
				if(!queue.isEmpty()){
					tail = queue.getLast();
				}
			}
			queue.poll();
			path.add(cur.val);
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
			
			if (cur == tail) {
				if(!queue.isEmpty()){
					head = queue.getFirst();
				}
				if ((curh & 1) == 0) {
					Collections.reverse(path);
				}
				res.add(new ArrayList<Integer>(path));
				path.clear();
				curh++;
			}
			

		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
//		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
//		TreeNode t4 = new TreeNode(5);
		root.left = t1;
//		root.right = t2;
		t1.left = t3;
//		t1.right = t4;
		Q103 q = new Q103();
		List<List<Integer>> res = q.zigzagLevelOrder(root);
		System.out.println(res);
	}
}
