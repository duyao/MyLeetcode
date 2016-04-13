package com.dy.leetcode;

public class Q9 {
	public boolean isPalindrome(int x) {
        if(x < 0 || (x!=0 && x%10==0)){
            return false;
        }
        int sum = 0;
        while(x > sum){
            sum = x%10 + sum*10;
            x/=10;
        }
        return (sum ==x)||(sum/10==x);
    }
	public static void main(String[] args) {
		int x = 1234321;
		Q9 q =new Q9();
		boolean b= q.isPalindrome(x);
		System.out.println(b);
	}

}
