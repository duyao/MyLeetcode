package com.dy.leetcode;

import java.util.HashMap;


public class Q316 {
	
	public static int findMinPos(HashMap<Character, Integer> map){
		int pos = Integer.MAX_VALUE;
		for (char c : map.keySet()) {
			int x = map.get(c);
			if(x < pos){
				pos = x;
			}
		}
		return pos;
	}
	
	/**
	 * 找到所有字母最后出现的位置，然后按照这些位置依次划分区间，找到每个区间中最小的字母
	 * @param s
	 * @return
	 */
	
	//"abacb"
	public String removeDuplicateLetters(String s) {
		if(s == null || s.length() == 0){
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			map.put(c[i], i);
		}
		int start = 0, end = findMinPos(map);
		char[] res = new char[map.size()];
		char min = 'z'+1;
		int curPos = 0;
		for(int j = 0; j < res.length; j++){
			for(int i = start; i <= end; i++){
				if(c[i] <= min && map.containsKey(c[i])){
					min = c[i];
					curPos = i;
				}
			}
			//先remove掉min，后面才可以重新查找
			res[j] = min;
			map.remove(min);
			
			if(min == c[end]){
				start = end + 1;
				end = findMinPos(map);
			}else{
				//从刚刚选中的下一个开始
				start = curPos + 1;
			}
			
			if(end < start){
				start = end;
			}
			//重置min
			min = 'z'+1;
		}
		
		
		return new String(res);
		
		
	}
	public static void main(String[] args) {
		Q316 q = new Q316();
		String s = q.removeDuplicateLetters("abacb");
		System.out.println(s);
	}
}
