package com.dy.leetcode;

import java.util.Stack;

public class Q151 {
	public String reverseWords(String s) {
		if(s == null || s.length() == 0){
			return "";
		}
		Stack<String> stack = new Stack<String>();
		String tmp = "";
		char[] c = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if(c[i] == ' '){
				if(!"".equals(tmp)){
					stack.add(tmp);
					tmp = "";
				}
			}else{
				tmp += c[i];
			}
		}
		if(!"".equals(tmp)){
			stack.add(tmp);
			tmp = "";
		}
		while(!stack.isEmpty()){
			tmp += stack.pop();
			tmp += " ";
		}
		if("".equals(tmp)){
			return "";
		}
		return tmp.substring(0, tmp.length()-1);

	}
	
	public static void main(String[] args) {
		String s = "  ";
		Q151 q = new Q151();
		 
		 System.out.println(q.reverseWords(s));
	}

}
