package com.dy.leetcode;

public class Q330 {
	public int minPatches(int[] nums, int n) {
		
		int miss = 0;
		int sum;
		int cnt = 0;
		if(nums == null ||nums.length == 0){
			sum = 0;
			miss = 1;
			cnt = 1;
			for(int i = 2; i < n; i++){
				if(i <= sum || i == sum + 1){
					sum += i;
				}else{
					miss = sum + 1;
					cnt++;
				}
			}
		}else{
			sum = nums[0];
			for(int i = 1; i < nums.length; i++){
				if(nums[i] <= sum || nums[i] == sum + 1){
					sum += nums[i];
				}else{
					miss = sum + 1;
					cnt++;
				}
				
			}
		}
		
		
		return cnt;

	}
	public static void main(String[] args) {
		int[] nums = {};
		int n = 20;
		Q330 q = new Q330();
		int x = q.minPatches(nums, n);
		System.out.println(x);
	}

}
