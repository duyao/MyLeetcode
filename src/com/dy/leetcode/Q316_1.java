package com.dy.leetcode;

import java.util.Stack;

public class Q316_1 {
	public String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		boolean[] b = new boolean[26];
		Stack<Character> stack = new Stack<Character>();
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			count[c[i]-'a']++;
		}
		for (int i = 0; i < c.length; i++) {
			count[c[i]-'a']--;
			while(!stack.isEmpty() && stack.peek() > c[i] && !b[c[i]-'a']&& count[stack.peek()-'a'] > 0){
				b[stack.peek()-'a'] = false;
				stack.pop();
				
			}
			if(!b[c[i]-'a']){
				stack.push(c[i]);
				b[c[i]-'a'] = true;
			}
		}
		StringBuffer sb = new StringBuffer();
		while(!stack.isEmpty()){
			sb.insert(0,stack.pop());
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Q316_1 q = new Q316_1();
		String s = q.removeDuplicateLetters("eeejjsbcabcsbbjehh");
		System.out.println(s);
	}

}
