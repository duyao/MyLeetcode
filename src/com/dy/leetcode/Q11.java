package com.dy.leetcode;

public class Q11 {
	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length-1;
		int res = 0;
		while(i < j){
			//Ãæ»ý
			int tmp = Math.abs(height[j] - height[i]) * Math.min(height[i], height[j]);
			res = Math.max(res, tmp);
			if(height[i] > height[j]){
				j--;
			}else{
				i++;
			}
		}
		return res;

	}

}
