package com.dy.leetcode;

public class Q263 {

	public boolean isUgly(int num) {
		if(num <= 0){
			return false;
		}else if (num > 0 && num < 6){
			return true;
		}else{
			while(num%2 == 0){
				num /= 2;
			}
			while(num%3 == 0){
				num /= 3;
			}
			while(num%5 == 0){
				num /= 5;
			}
			if(num == 1){
				return true;
			}else{
				return false;
			}
		}
	}

}
