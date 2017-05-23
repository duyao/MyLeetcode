package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Q49_1 {

	public static List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null || strs.length == 0){
			return null;
		}
		
		//key��������ĸ��ɣ�list�Ǿ�����ͬ��ĸ��ɵ��ַ���
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i = 0; i < strs.length; i++) {
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			//TODO
			//toString�õ�ÿ�������½��Ķ���
			String s = String.valueOf(c);
//			String s = c.toString();
			//System.out.println(s.hashCode());
			if(map.containsKey(s)){
				map.get(s).add(strs[i]);
			}else{
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(s, list);
			}
		}
		
		//TODO
		//����String[] strs = {"",""};�ó���lists�Ĵ�С��2
		//why????
//		List<List<String>> lists = new  ArrayList<List<String>>(map.values());
//		for (String ss : map.keySet()) {
//			List<String> list = map.get(ss);
//			Collections.sort(list);
//			lists.add(list);
//		}
		
		for (String ss : map.keySet()) {
			Collections.sort(map.get(ss));
		}
		return new  ArrayList<List<String>>(map.values());
//		return lists;
		
	}
	
	public static void main(String[] args) {
		String[] strs = {"",""};
//		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> list =groupAnagrams(strs);
		System.out.println(list.size());
	}
	
	

}
