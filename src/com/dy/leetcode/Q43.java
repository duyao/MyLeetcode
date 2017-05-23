package com.dy.leetcode;

import java.math.BigDecimal;

public class Q43 {
	public String multiply(String num1, String num2) {
		if(num1 == null && num2 == null || num1.length()==0 && num2.length()==0){
			return "";
		}
		BigDecimal n1 = new BigDecimal(num1);
		BigDecimal n2 = new BigDecimal(num2);
		BigDecimal n3 = n1.multiply(n2);
		return n3.toString();
	}
	
	public static void main(String[] args) {
		Q43 q = new Q43();
		String s = q.multiply("1111111111111111111111111", "222222222222222222222222222");
		System.out.println(s);
	}

}
