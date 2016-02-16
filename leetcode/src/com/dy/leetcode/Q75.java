package com.dy.leetcode;

public class Q75 {
	public void sortColors(int[] nums) {
		if(nums == null){
			return;
		}
		
		int i0 = 0;
		int i1 = 0;
		int i2 = 0;
		for(int i = 0; i < nums.length; i++){
			switch (nums[i]) {
			case 0:
				i0++;
				break;
			case 1: 
				i1++;
				break;
			case 2:
				i2++;
				break;
			}
		}
		int cnt = 0;
		while(cnt < nums.length){
			if(cnt < i0){
				nums[cnt++] = 0;
			}else if(cnt < i1+i0){
				nums[cnt++] = 1;
			}else{
				nums[cnt++] = 2;
			}
		}
		

	}

}
