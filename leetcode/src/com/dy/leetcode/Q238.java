package com.dy.leetcode;

public class Q238 {
	public int[] productExceptSelf(int[] nums) {
		long x = 1;
		int flag = -1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0 && flag == -1){
				flag = i;
			}else if(nums[i] != 0){
				x *= nums[i];
			}else{
				//ÓÐ2¸öÁã
				int[] res = new int[nums.length];
				return res;
			}
		}
		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			if(flag == -1){
				res[i] = (int) (x/nums[i]);
			}else{
				if(i == flag){
					res[i] = (int) x;
				}
			}
		}
		return res;

	}
	
	public static void main(String[] args) {
		Q238 q = new Q238();
		int[] nums = {0, 1};
		int[] res = q.productExceptSelf(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+",");
		}
	}

}
