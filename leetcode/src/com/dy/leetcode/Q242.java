package com.dy.leetcode;

public class Q242 {
    public static boolean isAnagram(String s, String t) {
        int[] hash = new int[26];
        for(int i = 0; i < s.length(); i++){
        	hash[s.charAt(i) - 97]++;
        }
        for(int i = 0; i < t.length(); i++){
        	hash[t.charAt(i) - 97]--;
        }
        for(int i = 0; i < hash.length; i++){
        	if(hash[i] != 0){
        		return false;
        	}
        }
        return true;
    }
    public static void main(String[] args) {
		String s = "cat";
		String t = "car";
		System.out.println(isAnagram(s, t));
	}

}
