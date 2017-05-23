package com.dy.leetcode;

import java.util.Stack;

public class Q331 {
	// ����Ҷ�ڵ㣬������##�滻Ϊ#
	// ���н����ջ�����ڿսڵ��ж�������������##�滻Ϊ#�����ջ��ֻ��#��������
	public boolean isValidSerialization(String preorder) {
		if(preorder == null || preorder.length() == 0){
			return false;
		}
		Stack<String> stack = new Stack<String>();
		String[] s = preorder.split(",");
		for (String string : s) {
			//ע��������while����Ϊ��������##��Ҫ�滻
			while(string.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
				//��#pop
				stack.pop();
				if(stack.empty()){
					return false;
				}
				//��ջ��Ԫ���滻Ϊ#
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
