package com.dy.leetcode;

public class Q66 {
	public int[] plusOne(int[] digits) {
        int w = 0;
        for(int i = digits.length-1; i >= 0; i--){
            int tmp = digits[i] + w;
            if(i == digits.length-1){
            	tmp++;
            }
            digits[i] = tmp % 10;
            if(tmp < 10){
                w = 0;
                break;
            }else{
                w = tmp / 10;
            }
        }
        if(w != 0){
            int[] res = new int[digits.length+1];
            res[0] = w;
            for (int i = 1; i < res.length; i++) {
				res[i] = digits[i-1];
			}
            return res;
        }
        return digits;
    }
	public static void main(String[] args) {
		Q66 q = new Q66();
		int[] digits = {9,9};
		int[]res = q.plusOne(digits);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
	}

}
