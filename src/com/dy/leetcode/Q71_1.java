package com.dy.leetcode;

import java.util.LinkedList;
//ʹ�÷ָ������
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
				//�����Ŀ¼�������ڷ�����һ��/home/../../..
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
