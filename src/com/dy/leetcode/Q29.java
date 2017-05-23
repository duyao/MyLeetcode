package com.dy.leetcode;

/**
 * Key idea: keep doubling divisor till no larger than dividend, then subtract
 * amplified divisor from dividend till dividend is small than original divisor
 * Example: 121 / 11 11<<1 --> 22<<1 --> 44<<1 --> 88, stop because 88<<1 = 176
 * > 121. divisor amplified 3 times, thus add 2<<3=8 to the final result update
 * dividend with 121-88 = 33 and continue with above procedure: 11<<1 --> 22<<1,
 * stop because 22<<1 = 44 > 33. final result = 8+2 = 10 update dividend with
 * 33-22 = 11 and continue with above procedure: stop because 11<<1 = 22 > 11.
 * final result = 10+1 = 11 update dividend with 11-11 = 0 and return
 */
public class Q29 {
	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		
		int signal = 1;
		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
			signal = -1;
		}
		
		if(Math.abs(divisor) == 1){
			return signal == 1 ? dividend : -dividend;
		}
		
		dividend = dividend>0 ? dividend : -dividend;
		divisor = divisor>0 ? divisor : -divisor;
		
		int result = 0;
		while(divisor <= dividend){
			int cnt = 1;
			int tmp = divisor;
			while(tmp > dividend << 1){
				//×ó³ËÓÒ³ý
				//³Ë2
				tmp = tmp << 1;
				cnt = cnt << 1;
			}
			result += cnt;
			dividend -= tmp;
		}
		return result * signal;

	}
	public static void main(String[] args) {
		Q29 q = new Q29();
		System.out.println(q.divide(Integer.MAX_VALUE, -2));
		
	}
}
