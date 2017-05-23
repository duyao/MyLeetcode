package com.dy.leetcode;

import java.util.Stack;

public class Q224 {
	// ʹ�ò�����ջ������ջ

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
	 * ��������ջ������ջ
	 * �������֣���������ջ
	 * ����������ţ��ж����ȼ�������ǰ�������ȼ��ߣ���ֱ����ջ�������ȼ���ջ�����ŵ�ֵ
	 * ����(�����ջ
	 * ����)���(��ǰ�ķ��ţ���������������Ӧ������뵽����ջ
	 * @param s
	 * @return
	 */
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// +-*/
		// w[i][j]Ϊ1��ʾi�����ȼ�����j
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
						// ��ǰ���ȼ��ͣ�������������������
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
				// ��������
				ops.pop();
				cnt++;
			} else if(c[cnt] == ' '){
				cnt++;
				continue;
			}else {
				String tmp = "";
				//cnt < c.length��ֹֻ����һ������
				while (cnt < c.length && c[cnt] >= '0' && c[cnt] <= '9') {
					tmp += c[cnt];
					cnt++;
				}
				int x = Integer.valueOf(tmp);
				num.push(x);
			}
		}
		//����ǰ�ȼ������еķ���
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
