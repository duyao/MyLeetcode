package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

import com.dy.leetcode.Q100.TreeNode;

public class Q95_1 {
	public List<TreeNode> generateTrees(int n) {
		return generate(1, n);
	}

	private ArrayList<TreeNode> generate(int start, int end) {
		ArrayList<TreeNode> rst = new ArrayList<TreeNode>();

		if (start > end) {
			rst.add(null);
			return rst;
		}

		for (int i = start; i <= end; i++) {
			ArrayList<TreeNode> left = generate(start, i - 1);
			System.out.println("left generate->" + start + "," + (i - 1));
			ArrayList<TreeNode> right = generate(i + 1, end);
			System.out.println("right generate->" + (i + 1) + "," + end);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					// should new a root here because it need to
					// be different for each tree
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					rst.add(root);
					System.out.println("add"+root.val+",l="+root.left+",r="+root.right);
				}
			}
		}
		return rst;
	}

	public static void main(String[] args) {
		Q95_1 q = new Q95_1();
		q.generateTrees(3);

	}

}
