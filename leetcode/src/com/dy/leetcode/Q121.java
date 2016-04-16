package com.dy.leetcode;

public class Q121 {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int minr = Integer.MAX_VALUE;
        int maxr = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
			minr = Math.min(minr, prices[i]);
			maxr = Math.max(maxr, prices[i]-minr);
		}
        return maxr-minr;
    }
	public static void main(String[] args) {
		int[] x= {1};
		Q121 q = new Q121();
		System.out.println(q.maxProfit(x));
		
	}

}
