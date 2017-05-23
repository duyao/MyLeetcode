package com.dy.leetcode;

import java.util.HashMap;

public class Q3_1 {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map  = new HashMap<Character, Integer>();
		int max = 0;
		for(int i = 0, j = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				//相当于substring
				j = Math.max(j, map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i-j+1);
		}
		return max;
        
    }

}
