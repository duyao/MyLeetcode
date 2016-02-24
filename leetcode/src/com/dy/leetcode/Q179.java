package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q179 {
	//如何排列逆序
	//有错
	public class cp implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			String longS = o1.length() <= o2.length() ? o2 : o1;
			String shortS = o1.length() >= o2.length() ? o2 : o1;
			int flag = 1;
			if(o1 != longS){
				o2 = shortS;
				o1 = longS;
				flag = -1;
			}
			
			//取短的
//			int len = o1.length() >= o2.length() ? o2.length() : o1.length();
			for (int i = 0; i < o2.length(); i++) {
				if(o1.charAt(i) > o2.charAt(i)){
					return 1*flag;
				}else if(o1.charAt(i) < o2.charAt(i)){
					return -1*flag;
				}
			}
			
			//比较剩余部分
			for(int i = o2.length();  i < o1.length(); i++){
				if(o1.charAt(i) > o2.charAt(0)){
					return 1*flag;
				}else if(o1.charAt(i) < o2.charAt(0)){
					return -1*flag;
				}
			}
			
			return 0;
		}
		
	}
	
	public String largestNumber(int[] nums) {
		String res = "";
		if(nums == null || nums.length == 0){
			return res;
		}
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < nums.length; i++) {
			list.add(String.valueOf(nums[i]));
		}
		Collections.sort(list, new cp());
		for (String string : list) {
			res = string + res; 
			
			System.out.println(string);
		}
		Collections.sort(list);
		for (String string : list) {
			res = string + res; 
			
			System.out.println(string);
		}
		System.out.println(res);
		return res;
		

	}
	
	public static void main(String[] args) {
		int[] nums = {4,3,61,32,81,97,35,99,3813,855};
		System.out.println('3' < '5');
		Q179 q = new Q179();
		q.largestNumber(nums);
	}

}
