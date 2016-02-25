package com.dy.leetcode;

import java.util.Stack;

public class Q224 {
	// 使用操作符栈和数字栈

	public static int getSys(char x) {
		int curOP = -1;
		switch (x) {
		case '+':
			curOP = 0;
			break;
		case '-':
			curOP = 1;
			break;
		case '*':
			curOP = 2;
			break;
		case '/':
			curOP = 3;
			break;

		}
		return curOP;
	}

	public static int cal(Stack<Integer> num, char c) {
		int b = num.pop();
		int a = num.pop();
		int x = 0;
		if (c == '+') {
			x = a + b;
		} else if (c == '-') {
			x = a - b;
		} else if (c == '*') {
			x = a * b;
		} else if (c == '/') {
			x = a / b;
		}
		return x;
	}

	/**
	 * 建立符号栈和数字栈
	 * 遇到数字，进入数字栈
	 * 遇到运算符号，判断优先级，若当前符号优先级高，则直接入栈，否认先计算栈顶符号的值
	 * 遇到(入符号栈
	 * 遇到)清空(以前的符号，并计算结果，将相应结果放入到数字栈
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// +-*/
		// w[i][j]为1表示i的优先级高于j
		int[][] w = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 0 },
				{ 1, 1, 0, 0 } };
		Stack<Integer> num = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();
		s.trim();
		char[] c = s.toCharArray();
		int cnt = 0;
		while (cnt < c.length) {
			if (c[cnt] == '+' || c[cnt] == '-' || c[cnt] == '*'
					|| c[cnt] == '/') {

				if (ops.empty() || ops.peek() == '(') {
					ops.push(c[cnt]);
				} else {
					if (w[getSys(c[cnt])][getSys(ops.peek())] == 0) {
						// 当前优先级低，计算结果，放入数字中
						int x = cal(num, ops.pop());
						num.push(x);
					}
					ops.push(c[cnt]);
				}
				cnt++;
			} else if (c[cnt] == '(') {
				ops.push('(');
				cnt++;
			} else if (c[cnt] == ')') {
				while (ops.peek() != '(') {
					int x = cal(num, ops.pop());
					num.push(x);
				}
				// 将（弹出
				ops.pop();
				cnt++;
			} else if(c[cnt] == ' '){
				cnt++;
				continue;
			}else {
				String tmp = "";
				//cnt < c.length防止只出现一个数字
				while (cnt < c.length && c[cnt] >= '0' && c[cnt] <= '9') {
					tmp += c[cnt];
					cnt++;
				}
				int x = Integer.valueOf(tmp);
				num.push(x);
			}
		}
		//返回前先计算所有的符号
		while(!ops.empty()){
			int res = cal(num, ops.pop());
			num.push(res);
		}
		return num.pop();
	}

	public static void main(String[] args) {
		String s = "0";
		Q224 q = new Q224();
		int x = q.calculate(s);
		System.out.println(x);
	}

}
