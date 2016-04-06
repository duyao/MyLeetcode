package com.dy.leetcode;


public class Q307 {
	 static class NumArray {
	    int[] array;
	    int n;
	    public NumArray(int[] nums) {
	        n = nums.length;
	        array = new int[2*n];
	        //init leaves
	        for(int i = 0; i < nums.length; i++){
	            array[n+i] = nums[i];
	        }
	        //init node
	        for(int i = n - 1; i > 0; i--){
	            array[i] = array[i << 1] + array[i << 1 | 1];
	        }
	        
	    }

	    void update(int i, int val) {
	        array[i+n] = val;
	        for(int j = i+n; j > 1; j >>= 1){
	            array[j >> 1] = array[j] + array[j ^ 1];
	        }
	        
	    }

	    public int sumRange(int i, int j) {
	        int sum = 0;
	        for(int l = i+n, r = j+n; l < r; l >>= 1 , r >>= 1){
	            //if left is right child, sum does not contain parent
	            if((l&1) == 1){
	                sum += array[l++];
	            }
	            if((r&1) == 1){
	                sum += array[--r];
	            }
	        }
	        return sum+array[j+n];
	        
	    }
	}
	
	
	public static void main(String[] args) {
		Q307 q = new Q307();
		int[] nums = new int[13];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		
		NumArray a = new NumArray(nums);
		int x = a.sumRange(0,7);
		System.out.println(x);
		a.update(1,2);
		x= a.sumRange(0,2);
		System.out.println(x);
		a.update(4, 0);
		x = a.sumRange(0, 4);
		System.out.println(x);
	}

}
