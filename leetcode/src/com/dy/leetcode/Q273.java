package com.dy.leetcode;

import java.util.Stack;

public class Q273 {
	private final static String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	private final static String[] thousands = {"", "Thousand", "Million", "Billion"};
	public static int getNum(String s){
		for(int i = 0; i < lessThan20.length; i++){
			if(s.equals(lessThan20[i])){
				return i;
			}
		}
		return 0;
	}
	public static String numberToWords(int num) {
		Stack<String> s = new Stack<String>();
		if(num == 0){
			return "Zero";
		}
		int cnt = 0;
		while(num != 0){
			
			
			int tmp = num % 1000;
			if(tmp != 0){
				s.push(thousands[cnt]+" ");
			}
			
			int ccnt = 0;
			while(tmp != 0){
				int ttmp = tmp % 10;
				if(ccnt == 0 && ttmp != 0){
					s.push(lessThan20[ttmp]+" ");
				}else if(ccnt == 1 && ttmp != 0){
					if(ttmp == 1 ){
						int x = getNum(s.peek().trim());
						if(x != 0){
							s.pop();
						}
						s.push(lessThan20[ttmp*10 + x]+" ");
					}else{
						s.push(tens[ttmp]+" ");
					}
				}else if(ccnt == 2 & ttmp!= 0){
					s.push(lessThan20[ttmp]+" Hundred"+" ");
				}
				
				tmp /= 10;
				ccnt++;
			}
			num /= 1000;
			cnt ++;
			
		}
		String res = "";
		
		while(!s.empty()){
			res += s.pop();
		}
		int end = 0;
		for(int i = res.length()-1; i >= 0; i--){
			if(res.charAt(i) == ' '){
				end++;
				if(res.charAt(i-1) != ' ' ){
					break;
				}
			}
		}
		return res.substring(0, res.length()-end);
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Q273 q = new Q273();
		String s = q.numberToWords(1001000);
		System.out.println(s);
		System.out.println(s.length());
		
	}

}
