package com.dy.leetcode;

import java.util.Stack;

public class Q224 {
	// ʹ�ò�����ջ������ջ

	// +-*/
	// w[i][j]Ϊ1��ʾi�����ȼ�����j
	int[][] w = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 0, 0 },
			{ 1, 1, 0, 0 } };
	Stack<Integer> num = new Stack<Integer>();
	Stack<Integer> ops = new Stack<Integer>();

	public int calculate(String s) {
		s.trim();
		char[] c = s.toCharArray();
		int cnt = 0;
		while(cnt < c.length){
			if(c[cnt] == '+' || c[cnt] == '-' || c[cnt] == '*' || c[cnt] == '/'){
				//TODO
				int curOP = -1;
				switch (c[cnt]) {
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
				if(ops.empty()){
					ops.push(curOP);
				}else{
					if(w[curOP][ops.peek()] == 1){
						//��ǰ���ȼ���
						ops.push(curOP);
					}else{
						int b = num.pop();
						int a = num.pop();
						int x = a c[cnt] b;
						num.push(x);
						
					}
				}
			}
		}
	}

}
