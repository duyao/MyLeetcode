package com.dy.leetcode;

import com.dy.leetcode.Q101.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dy on 2016/9/28.
 */
public class Q102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return res;
		}
		queue.add(root);
		TreeNode tail = root;
		//判断条件时queue.isEmpty()或者queue.size() != 0不是判空
		while (!queue.isEmpty()) {

			TreeNode cur = queue.removeFirst();
			list.add(cur.val);
			if (cur.left != null) {
				queue.add(cur.left);
			}
			if (cur.right != null) {
				queue.add(cur.right);
			}
			//判断条件时queue.isEmpty()或者queue.size() != 0不是判空
			if (queue.size() != 0 && tail == cur) {
				//空指针
//				System.out.println("tail->"+queue);
				tail = queue.getLast();
				res.add(new ArrayList<>(list));
				list.clear();
			}
		}
		res.add(list);
		System.out.println(res);
		return res;

	}

	public static void main(String[] args) {

		Q102 q = new Q102();
		//[3,4,4,5,null,null,5,6,null,null,6]
		TreeNode root = new TreeNode(3);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(10);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(12);
		root.left = t2;
//		root.right = t3;
//		t2.left = t4;
//		t3.right = t5;
//		t4.left = t6;
//		t5.right = t7;
		q.levelOrder(root);


	}
}
