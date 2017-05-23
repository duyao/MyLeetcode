package com.dy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q136 {

	//ʹ��set�ж��Ƿ����
	public int singleNumber1(int[] nums) {
		int ans = -1;
		//treeset����hashset����
		Set<Integer> set = new HashSet<Integer>();
		set.add(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			if(set.contains(nums[i])){
				set.remove(nums[i]);
			}else{
				set.add(nums[i]);
			}
		}
		for (Integer i : set) {
			ans = i;
		}
		return ans;
	}
	
	//ʹ�����^
	//1.a^b=b^a;2.0^a=a
	//����������������������㣬�����ظ������������ȣ�Ȼ�������������1��
	//�뿪ʼ��0�����0�������һ����ͬ����������Ǹò�ͬ������
	public int singleNumber2(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans ^= nums[i];
		}
		return ans;
	}
	
}
