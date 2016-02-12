package com.dy.leetcode;

public class Q155 {
	int max = 100000;
	int[] val = new int[max];
	int[] min = new int[max];
	int top = -1;

	public void push(int x) {
		if(top == -1 || x <= min[top] ){
			min[++top] = x;
			val[top] = x;
		}else{
			val[++top] = x;
			min[top] = min[top-1];
		}
	}

	public void pop() {
		top--;
	}

	public int top() {
		return val[top];
	}

	public int getMin() {
		return min[top];
	}
	
	public static void main(String[] args) {
		Q155 q = new Q155();
		q.push(-2);
		q.push(0);
		q.push(-1);
		q.getMin();
		q.top();
		q.pop();
		q.getMin();
		
		System.out.println(q.getMin());
	}

}
