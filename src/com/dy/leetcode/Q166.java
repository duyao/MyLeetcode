package com.dy.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Q166 {
	public String fractionToDecimal(int numerator, int denominator) {
		// BigDecimal up = new BigDecimal(numerator);
		// BigDecimal down = new BigDecimal(denominator);
		// String result =
		// up.divide(down,3,RoundingMode.CEILING).toPlainString();
		// System.out.println(result);
		// return result;
		StringBuffer res = new StringBuffer();
		
		if (denominator == 0) {
			return "0";
		}
		
		//必须先判断符号，用除法记录符号不管用，因为有可能商是0
		if(numerator > 0 &&denominator < 0 || numerator < 0 && denominator > 0){
			res.append("-");
		}
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		res.append(num / den);
		if (numerator % denominator == 0) {
			return res.toString();
		}
		res.append(".");
		int start = res.length()-1;
		//记录该余数的位置，后面插入括号使用
		Map<Long, Integer> index = new HashMap<Long, Integer>(); 
		long remainder = num % den;
		while(remainder != 0){
			remainder *= 10;
			if(index.containsKey(remainder)){
				
				res.insert(index.get(remainder),"(");
				res.append(")");
				break;
			}else{
				index.put(remainder,++start);
				res.append(remainder/den);
				remainder = remainder%den;
				
			}
			
		}
		
		return res.toString();

	}

	public static void main(String[] args) {
		Q166 q = new Q166();
//		String s = q.fractionToDecimal(2, 3);
		String s = q.fractionToDecimal(-2, 7);
		System.out.println(s);

	}

}
