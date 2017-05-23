package com.dy.leetcode;

public class Q96_1 {
	//https://www.quora.com/Given-n-how-many-structurally-unique-BSTs-binary-search-trees-that-store-values-1-to-n-are-there
	//¿¨ÌØÀ¼Êı
	public int numTrees(int n) {
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int [] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        res[2] = 2;
        
        for(int i = 3; i <= n; i++){
            int sum = 0;
            for(int j = 0; j < i; j++){
                sum += res[j] * res[i-1-j];
            }
            res[i] = sum;
        }
        return res[n];
        
    }

}
