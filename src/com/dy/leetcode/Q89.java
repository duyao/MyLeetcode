package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q89 {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1 << n; i++) {
//			System.out.println(i +" ^ "+(i >> 1) +" = "+(i ^ (i >> 1)));
			list.add(i ^ i >> 1);
		}
		System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		Q89 q = new Q89();
		List<Integer> list = q.grayCode(4);
//		System.out.println(list);

	}
}
