package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q89_1 {
	public List<Integer> grayCode(int n) {
		List<String> list = new ArrayList<String>();
		List<Integer> res = new ArrayList<Integer>();
		list.add("");
		if(n == 0){
		    res.add(0);
		    return res;
		}
		for (int i = 0; i < n; i++) {
			List<String> tlist = new ArrayList<String>();
			for (String s : list) {
				String a = "0" + s;
				tlist.add(a);
			}
			//mirror situation
			for (int j = list.size()-1; j >= 0; j--) {
				String s = list.get(j);
				String a = "1" + s;
				tlist.add(a);
			}
			list = tlist;
		}
		for (int i = 0; i < list.size(); i++) {
			int tmp = Integer.parseInt(list.get(i),2);
			res.add(tmp);
		}
		return res;
	}
	public static void main(String[] args) {
		Q89_1 q = new Q89_1();
		List<Integer> list = q.grayCode(3);
		System.out.println(list);

	}

}
