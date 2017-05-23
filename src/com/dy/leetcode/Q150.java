package com.dy.leetcode;

import java.util.Stack;

public class Q150 {
	public int evalRPN(String[] tokens) {
		if(tokens == null || tokens.length == 0){
			return 0;
		}
		Stack<Long> nums = new Stack<Long>();
		for (String s : tokens) {
			if(s.equals("+")){
				cal(nums, '+');
			}else if(s.equals("-")){
				cal(nums, '-');
			}else if(s.equals("*")){
				cal(nums, '*');
			}else if(s.equals("/")){
				cal(nums, '/');
			}else{
				long x = Long.valueOf(s);
				nums.push(x);
			}
		}
		return nums.pop().intValue();

	}
	
	public void cal(Stack<Long> nums, char x){
		long b = nums.pop();
		long a = nums.pop();
		switch (x) {
		case '+':
			nums.push(a+b);
			break;
		case '-':
			nums.push(a-b);
			break;
		case '*':
			nums.push(a*b);
			break;
		case '/':
			nums.push(a/b);
			break;

		}
		
	}
	
	public static void main(String[] args) {
		String[] s = {"4", "13", "5", "/", "+"};
		Q150 q = new Q150();
		int x = q.evalRPN(s);
		System.out.println(x);
	}

}
