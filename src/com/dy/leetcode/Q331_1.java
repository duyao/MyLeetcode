package com.dy.leetcode;

public class Q331_1 {

	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
		int diff = 1;
		for (String node : nodes) {
			if (--diff < 0)
				return false;
			if (!node.equals("#"))
				diff += 2;
		}
		return diff == 0;

	}

	public static void main(String[] args) {
		Q331_1 q = new Q331_1();
		String s = "#,#,4,#,#,1,3,#,#,#,6,2,9";
		boolean b = q.isValidSerialization(s);
		System.out.println(b);
	}

}
