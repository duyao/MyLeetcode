package com.dy.leetcode;

import java.util.LinkedList;
//使用分割符处理
public class Q71_1 {
	public String simplifyPath(String path) {
		if(path == null ||  path.length() == 0){
			return "";
		}
		LinkedList<String> list = new LinkedList<String>();
		list.add("/");
		String [] words = path.split("/");
		for (String s : words) {
			if(".".equals(s)){
				continue;
			}
			else if("..".equals(s)){
				//到达根目录，不能在返回上一级/home/../../..
				if(!list.isEmpty()){
					list.removeLast();
				}
			}
			else if(!"".equals(s)){
				list.add(s);
			}
		}
		String s = "";
		if(!list.isEmpty() && list.getFirst().equals("/")){
			list.removeFirst();
		}
		while(!list.isEmpty()){
			s += "/" + list.removeFirst();
		}
		if("".equals(s)){
			return "/";
		}
			
		return s;
		
	}
	
	public static void main(String[] args) {
		String path = "/home/../../..";
		Q71_1 q = new Q71_1();
		System.out.println(q.simplifyPath(path));
	}

}
