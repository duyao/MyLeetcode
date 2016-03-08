package com.dy.leetcode;

import java.util.Stack;

public class Q331 {
	// 砍掉叶节点，连续的##替换为#
	// 所有结点入栈，对于空节点判断若存在连续的##替换为#，最后栈中只有#，则是树
	public boolean isValidSerialization(String preorder) {
		if(preorder == null || preorder.length() == 0){
			return false;
		}
		Stack<String> stack = new Stack<String>();
		String[] s = preorder.split(",");
		for (String string : s) {
			//注意这里是while，因为遇到连续##就要替换
			while(string.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
				//将#pop
				stack.pop();
				if(stack.empty()){
					return false;
				}
				//将栈顶元素替换为#
				stack.pop();
			}
			stack.push(string);
			
		}
		if(stack.size() == 1 && stack.peek().equals("#")){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Q331 q = new Q331();
		String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		boolean b = q.isValidSerialization(s);
		System.out.println(b);
	}

}
