package com.dy.leetcode;

import java.util.Stack;
//处理很麻烦，有很多边界，比如/....hi/...../c
public class Q71 {
	public String simplifyPath(String path) {
		if(path == null ||  path.length() == 0){
			return "";
		}
		Stack<String> stack = new Stack<String>();
		stack.add("/");
		char[] c = path.toCharArray();
		String tmp = "";
		boolean dot = false;
		for (int i = 0; i < c.length; i++) {
			if(c[i] == '/'){
				if(!"".equals(tmp)){
					stack.add(tmp);
					tmp = "";
				}
				dot = false;
			}else{
				if(c[i] == '.'){
					if(dot){
						if(!stack.empty()){
							
							stack.pop();
						}
						dot = false;
					}else{
						dot = true;
					}
					
				}else{
					dot = false;
					tmp += c[i];
				}
				
			}
		}
		if(!"".equals(tmp)){
			stack.add(tmp);
			tmp = "";
		}
//		if(stack.empty()){
//			return "/";
//		}
		while(!stack.empty() && !stack.peek().equals("/")){
			String s = new String(tmp);
			s = "/" + stack.pop() + tmp;
			tmp = s;
		}
		if("".equals(tmp)){
			return "/";
		}
		return tmp;
	}
	
	public static void main(String[] args) {
		String path = "/....hidden";
		Q71 q = new Q71();
		System.out.println(q.simplifyPath(path));
	}

}
