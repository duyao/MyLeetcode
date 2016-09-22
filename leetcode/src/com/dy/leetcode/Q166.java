package com.dy.leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

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
		res.append(numerator / denominator);
		if (numerator % denominator == 0) {
			return res.toString();
		}
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		long remainder = num % den;
		while(remainder != 0){
			if(map.containsKey(remainder)){
				res.append(".("+map.keySet().toString()+")");
				map.put(remainder,remainder);
				res.append(String.valueOf(remainder*10/den));
				remainder = remainder*10%den;
			}
		}
		
		res.append(")");
		return res.toString();

	}

	public static void main(String[] args) {
		Q166 q = new Q166();
		String s = q.fractionToDecimal(2, 8);
		System.out.println(s);

	}

}
