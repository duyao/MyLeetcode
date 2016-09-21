package com.dy.leetcode;

import java.util.ArrayList;

import com.dy.leetcode.Q100.TreeNode;

public class Q98_1 {
	public boolean isValidBST(TreeNode root) {
		return travel(root, new ArrayList<Integer>());
	}

	private boolean travel(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			boolean bl = travel(root.left, list);
			if (list.size() > 0 && list.get(list.size() - 1) >= root.val) {
				return false;
			} else {
				list.add(root.val);
			}
			boolean br = travel(root.right, list);
			return br && bl;
		}else{
			return true;
		}
	}

}
