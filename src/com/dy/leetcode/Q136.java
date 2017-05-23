package com.dy.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q136 {

	//使用set判断是否存在
	public int singleNumber1(int[] nums) {
		int ans = -1;
		//treeset有序，hashset无序
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
	
	//使用异或^
	//1.a^b=b^a;2.0^a=a
	//将序列中所有数字异或运算，所有重复的数字异或相等，然后他们再异或是1，
	//与开始的0异或是0，与最后一个不同的数字异或是该不同的数字
	public int singleNumber2(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			ans ^= nums[i];
		}
		return ans;
	}
	
}
