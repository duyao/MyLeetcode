package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
	public List<List<String>> partition(String s) {List<List<String>> res = new ArrayList<List<String>>();if (s == null || s.length() == 0) {return res;}for(int i = 1; i <= s.length(); i++){f(s, 0, i, new ArrayList<String>(), res);}return res;}public void f(String str, int s, int e, List<String> path,List<List<String>> res) {String tmp = str.substring(s, e);if (e == str.length()) {if (isp(tmp)) {path.add(tmp);res.add(new ArrayList<String>(path));path.remove(path.size() - 1);}return;}if (isp(tmp)) {path.add(tmp);for (int i = 0; i < str.length() - e; i++) {f(str, e, e + 1 + i, path, res);}path.remove(path.size() - 1);}}public boolean isp(String str) {int i = 0;int j = str.length() - 1;while (i < j) {if (str.charAt(i++) != str.charAt(j--)) {return false;}}return true;}

	public static void main(String[] args) {
		Q131 q = new Q131();
		String s = "aabbbc";
		List<List<String>> res = q.partition(s);
		System.out.println(res.size());
		for (List<String> list : res) {
			System.out.println(list);
		}
		
	}

}
