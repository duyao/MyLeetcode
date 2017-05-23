package com.dy.leetcode;

import java.util.HashMap;

public class Q316 {

	public static int findMinPos(HashMap<Character, Integer> map) {
		int pos = Integer.MAX_VALUE;
		for (char c : map.keySet()) {
			int x = map.get(c);
			if (x < pos) {
				pos = x;
			}
		}
		return pos;
	}

	/**
	 * 找到所有字母最后出现的位置，然后按照这些位置依次划分区间，找到每个区间中最小的字母
	 * 
	 * @param s
	 * @return
	 */
	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			map.put(c[i], i);
		}
		int start = 0, end = findMinPos(map);
		char[] res = new char[map.size()];
		char min = 'z' + 1;
		for (int j = 0; j < res.length; j++) {
			// 区间内部找最小值
			for (int i = start; i <= end; i++) {
				//这里一定是c[i] < min，无等号，这样才能找到一个min出现的位置
				if (c[i] < min && map.containsKey(c[i])) {
					min = c[i];
					start = i + 1;
				}
			}
			// 先remove掉min，后面才可以重新查找
			res[j] = min;
			map.remove(min);
			
			if (min == c[end]) {
				end = findMinPos(map);
			}

			// 重置min
			min = 'z' + 1;
		}

		return new String(res);

	}

	public static void main(String[] args) {
		Q316 q = new Q316();
		String s = q.removeDuplicateLetters("abacb");
		System.out.println(s);
	}
}
