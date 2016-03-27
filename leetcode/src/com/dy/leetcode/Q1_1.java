package com.dy.leetcode;

import java.util.HashMap;

public class Q1_1 {
	//��ֵ���±���Ϊ��ֵ����map��
	//ÿ��ֵ���뿴map���Ƿ������ֿ�����ɺ�
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])){
				return new int[]{target - nums[i],i};
			}else{
				map.put(nums[i], i);
			}
		}
		return null;

	}

}
