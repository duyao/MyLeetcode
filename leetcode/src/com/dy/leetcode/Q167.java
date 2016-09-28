package com.dy.leetcode;

/**
 * Created by dy on 2016/9/28.
 */
public class Q167 {

	public int[] twoSum(int[] numbers, int target) {
		int i = 0, j = numbers.length - 1;
		while(i < j){
			if(numbers[i]+numbers[j]<target){
				i++;
			}else if(numbers[i]+numbers[j]>target){
				j--;
			}else{
				return new int[]{i,j};
			}
		}
		return null;
	}
	public static void main(String[] args) {


	}
}
