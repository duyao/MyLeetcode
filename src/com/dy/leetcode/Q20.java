package com.dy.leetcode;

import java.util.Stack;

public class Q20 {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0 || ((s.length() & 1) == 1)) {
			return false;
		}
		Stack<Character> stack = new Stack<>();
		char[] c = s.toCharArray();
		int i = 0;
		while (i < c.length) {
			if (c[i] == '(' || c[i] == '{' || c[i] == '[') {
				stack.push(c[i]);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					if (c[i] == ']' && stack.peek() != '[') {
						return false;
					} else if (c[i] == '}' && stack.peek() != '{') {
						return false;
					} else if (c[i] == ')' && stack.peek() != '(') {
						return false;
					}
					stack.pop();
				}
			}
			i++;
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Q20 q = new Q20();
		q.isValid("()");
	}
}
