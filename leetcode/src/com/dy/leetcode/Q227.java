package com.dy.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Q227 {
	public int calculate(String s) {

		int[][] w = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 0 },
				{ 1, 1, 0, 0 } };

		Stack<Integer> num = new Stack<Integer>();
		Stack<Integer> op = new Stack<Integer>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('+', 0);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 3);
		int index = 0;
		char[] c = s.toCharArray();
		while (c[index] != '\n') {

			if (c[index] == '+' || c[index] == '-' || c[index] == '*' || c[index] == '/') {
				int curOp = map.get(c[index]);
				
				if(op.isEmpty()){
					op.push(curOp);
					index++;
				}else{
					if (w[curOp][op.peek()] == 1) {
						//find next num
						StringBuffer sb = new StringBuffer();
						while (c[++index] >= '0' && c[index] <= '9' || c[index] == ' ') {
							if(c[index] == ' '){
								index++;
							}else{
								sb.append(c[index]);
							}
						}
						int tmp = Integer.valueOf(sb.toString());
						int t = cal(tmp, num.pop(), curOp);
						num.push(t);
						//index have done++

					} else {
						int tmp = cal(num.pop(), num.pop(), op.pop());
						num.push(tmp);
						op.push(curOp);
						
					}
				}
				
			}else if(c[index] == ' '){
				index++;
			}else{
				StringBuffer sb = new StringBuffer();
				while (c[index] >= '0' && c[index] <= '9' || c[index] == ' ') {
					if(c[index] == ' '){
						index++;
					}else{
						sb.append(c[index++]);
					}
				}
				int tmp = Integer.valueOf(sb.toString());
				num.push(tmp);
			}

		}
		while(op.isEmpty()){
			int x = cal(num.pop(), num.pop(), op.pop());
			num.push(x);
		}
		return num.pop();

	}

	public int cal(int b, int a, int c) {
		if (c == 0) {
			return a + b;
		} else if (c == 1) {
			return a - b;
		} else if (c == 2) {
			return a * b;
		} else {
			return a / b;
		}
	}


	public void f(Stack<Integer> num, Stack<Integer> op, String s, int i) {
		if (s.charAt(i) == '+') {

		}
	}
	
	public static void main(String[] args) {
		Q227 q = new Q227();
		String s = "    1    3+2 0 /2- 1 * 55 -4/  2";
		int x  = q.calculate(s);
		System.out.println(x);
	}

}
