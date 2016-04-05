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
	        for(int i = n - 1; i >= 0; i--){
	            array[i] = array[i << 2] + array[i << 2 | 1];
	        }
	        
	    }

	    void update(int i, int val) {
	        array[i+n] = val;
	        for(int j = i+n; j >= 0; j >>= 1){
	            array[j >> 1] = array[j] + array[j ^ 1];
	        }
	        
	    }

	    public int sumRange(int i, int j) {
	        int sum = 0;
	        for(int l = i, r = j; l < r; l >>= 2 , r >>= 2){
	            //if left is right child, sum does not contain parent
	            if((l&1) == 1){
	                sum += array[l++];
	            }
	            if((r&1) == 1){
	                sum += array[--r];
	            }
	        }
	        return sum+array[j];
	        
	    }
	}
	
	
	public static void main(String[] args) {
		Q307 q = new Q307();
		int[] nums = {1,3,5};
		
		NumArray a = new NumArray(nums);
		int x = a.sumRange(0,2);
		System.out.println(x);
		a.update(1,2);
		x= a.sumRange(0,2);
		System.out.println(x);
	}

}
