package com.dy.leetcode;

public class Q169 {
	public int majorityElement(int[] nums) {
		//��¼����cnt�͵�ǰ��ֵvalue
		//��ֵ��ͬ��cnt++,����cnt--
		//��cntΪ0,����value��cnt
		int value = nums[0];
		int cnt = 1;
		for (int i = 1; i < nums.length; i++) {
			if(value == nums[i]){
				cnt++;
			}else{
				cnt--;
				if(cnt == 0){
					value = nums[i];
					cnt++;
				}
			}
		}
		return value;

	}
}
