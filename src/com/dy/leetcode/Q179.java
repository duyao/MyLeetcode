package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q179 {
	// 如何排列逆序
	// 有错
	public class cp implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return -1*(o1+o2).compareTo(o2+o1);
//			String longS = o1.length() <= o2.length() ? o2 : o1;
//			String shortS = o1.length() > o2.length() ? o2 : o1;
//			// 返回逆序
//			int flag = -1;
//			if (o1 != longS) {
//				o2 = shortS;
//				o1 = longS;
//				flag = 1;
//			}
//
//			// 取短的
//			// int len = o1.length() >= o2.length() ? o2.length() : o1.length();
//			for (int i = 0; i < o2.length(); i++) {
//				if (o1.charAt(i) > o2.charAt(i)) {
//					return 1 * flag;
//				} else if (o1.charAt(i) < o2.charAt(i)) {
//					return -1 * flag;
//				}
//			}
//
//			// 比较剩余部分,{23,234,232}
//			int i;
//			for (i = o2.length(); i < o1.length(); i++) {
//				if (o1.charAt(i) > o2.charAt(0)) {
//					return 1 * flag;
//				} else if (o1.charAt(i) < o2.charAt(0)) {
//					return -1 * flag;
//				}
//			}
//
//			return -1*flag;
		}
	}

	public String largestNumber(int[] nums) {
		StringBuffer res = new StringBuffer();
		if (nums == null || nums.length == 0) {
			return res.toString();
		}
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			list.add(String.valueOf(nums[i]));
		}
		// System.out.println(list);
		// System.out.println("========sort==========");
		Collections.sort(list, new cp());
		for (String string : list) {
			res.append(string);
		}

		System.out.println(list);
		System.out.println("res->" + res);
		if (res.toString().startsWith("0")) {
			return "0";
		}
		return res.toString();

	}

	public static void main(String[] args) {
		// int[] nums = {4,3,61,32,81,97,35,99,3813,855};
//		 int[] nums = {121,12};
		 int[] nums = { 830, 8308 };
		// System.out.println('3' < '5');
		Q179 q = new Q179();
		q.largestNumber(nums);
	}

}
