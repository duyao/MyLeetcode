package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q49_1 {

	public List<List<String>> groupAnagrams(String[] strs) {
		//key是有序字母组成，list是具有相同字母组成的字符串
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			if(map.containsKey(c)){
				map.get(c).add(strs[i]);
			}else{
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(c.toString(), list);
			}
		}
	}

}
