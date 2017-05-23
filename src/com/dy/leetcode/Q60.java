package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q60 {
	public String getPermutation(int n, int k) {
		List<String> list = new ArrayList<String>();
		list.add("");
		for(int i = 1; i <= n; i++){
			List<String> tmp = new ArrayList<String>();
			for (String string : list) {
				for (int j = 0; j <= string.length(); j++) {
					StringBuilder sb = new StringBuilder(string);
					sb.insert(j, i);
					tmp.add(sb.toString());
//					list.add(sb.toString());
				}
			}
			list = tmp;
		}
		Collections.sort(list);
//		for (String string : list) {
//			
//			System.out.println(string);
//		}
		return list.get(k-1);

	}
	public static void main(String[] args) {
		Q60 q = new Q60();
		System.out.println(q.getPermutation(4, 16));
	}

}
