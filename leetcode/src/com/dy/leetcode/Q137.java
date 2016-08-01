package com.dy.leetcode;

public class Q137 {
	public int singleNumber(int[] nums) {
        int bitnum[]=new int[32];  
        int res=0;  
        for(int i=0; i<32; i++){  
            for(int j=0; j<nums.length; j++){  
                bitnum[i]+=(nums[j]>>i)&1;  
            }  
            res|=(bitnum[i]%3)<<i;  
        }  
        return res;
        
    }
	public static void main(String[] args) {
		
	}
}
