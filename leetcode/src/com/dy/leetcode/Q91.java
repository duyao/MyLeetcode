package com.dy.leetcode;

import java.awt.datatransfer.StringSelection;

public class Q91 {
	public int numDecodings(String s) {
		if(s != null || s.length() != 0){
			return f(s,0,s.length());
		}
		return 0;
	}
	public int f(String str, int  s, int e){
		if(s == e){
			return 0;
		}else if(s == e-1){
			int tmp = Integer.valueOf(str.substring(s,e));
			return tmp > 0 && tmp < 27 ? 1 : 0;
		}else{
			int tmp = Integer.valueOf(str.substring(s,e));
			tmp = tmp > 0 && tmp < 27 ? 1 : 0;
			for(int i = 1; i < e - s;i++){
				int x = Math.max(f(str, s, s+i), f(str, s+i, e));
				tmp += x;
				System.out.println(x +"," +str.substring(s, s+i)+","+str.substring(s+i, e));
			}
			return tmp;
		}
	}
	public static void main(String[] args) {
		String s = "1314";
		Q91 q = new Q91();
		int x = q.numDecodings(s);
		System.out.println(x);
	}

}
