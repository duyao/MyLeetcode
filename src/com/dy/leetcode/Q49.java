package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q49 {
	
	public static int[] getHash(String s){
		int[] hash = new int[26];
		for (int j = 0; j < s.length(); j++) {
			hash[s.charAt(j)-97] = 1;
		}
		return hash;
		
	}
	
	public static boolean compareHash(int[] a,int[] b){
		for (int i = 0; i < b.length; i++) {
			if(a[i] != b[i]){
				return false;
			}
		}
		return true;
	}

	//双重循环，tle
	public static List<List<String>> groupAnagrams(String[] strs) {
		if(strs == null){
			return null;
		}
		//计算一共多少组
		int cnt = 1;
		//相同值的序号对应的数组为同一组，0表示还没有分组
		int[] group = new int[strs.length];
		for(int i = 0; i < strs.length; i++){
			if(group[i] == 0){
				group[i] = cnt;
				int[] oral = getHash(strs[i]);
				//对后面的每一组校验
				for(int j = i + 1; j < strs.length; j++){
					if(group[j] == 0){
						if(compareHash(oral, getHash(strs[j]))){
							group[j] = cnt;
						}
						
					}
				}
				cnt++;
			}
		}
		
		List<List<String>> result = new ArrayList<List<String>>();
		for(int i = 1; i < cnt; i++){
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < group.length; j++) {
				if(group[j] == i){
					list.add(strs[j]);
				}
			}
			Collections.sort(list);
			result.add(list);
		}
		
		return result;
	}
	public static void main(String[] args) {
		String[] s= {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = groupAnagrams(s);
		System.out.println("size"+lists.size());
	}
}
