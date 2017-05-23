package com.dy.leetcode;

import java.util.HashMap;

/**
 * Created by dy on 2016/9/27.
 */
public class Q80 {

	//[1,1,1,2]为什么错？
	public int removeDuplicates(int[] nums) {
		int cnt = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (map.get(nums[i]) == 1) {
					map.put(nums[i], 2);
					if(pos != 0){
						nums[pos++] = nums[i];
					}
				} else {
					pos = pos == 0 ? i :pos;

					while (map.containsKey(nums[i]) && (map.get(nums[i]) > 1)) {
						i++;
						if(i >= nums.length){
							return pos;
						}
					}

					nums[pos++] = nums[i];
					if (map.containsKey(nums[i])) {
						map.put(nums[i], 2);
					} else {
						map.put(nums[i], 1);
					}

				}
			}else{
				map.put(nums[i],1);
				if(pos != 0){
					nums[pos++] = nums[i];
				}
			}

		}
		System.out.println("pos="+pos);
		return nums.length-cnt;
	}



	public static void main(String[] args) {
		int[] a = {1,1,1,2};
		Q80 q = new Q80();
		q.removeDuplicates(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + ",");
		}

	}
}
