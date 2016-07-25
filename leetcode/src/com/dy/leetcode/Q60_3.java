package com.dy.leetcode;

import java.util.ArrayList;

public class Q60_3 {
	
	public String getPermutation(int n, int k) {
		int[] f = new int[11];
		f[1] = 1;
		for (int i = 2; i < f.length; i++) {
			f[i] = i * f[i-1];
		}
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			list.add(i+"");
		}
		
		StringBuffer sb = new StringBuffer();
		--n;
		while(n > 0){
			
			int x = f[n];
			int cnt = 0;
			while(k > x*(cnt+1)){
				cnt++;
			}
			sb.append(list.get(cnt));
			list.remove(cnt);
			k -= cnt*x;
			
			n--;
			
		}
		sb.append(list.get(0));
		return sb.toString();
		
	}
	public static void main(String[] args) {
		Q60_3 q = new Q60_3();
		System.out.println(q.getPermutation(1, 1));
	}

}
