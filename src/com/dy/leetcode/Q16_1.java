package com.dy.leetcode;

import java.util.Arrays;
import java.util.TreeSet;
public class Q16_1 {
	public int myComparor(int a, int b, int target){
		return Math.abs(target-a) < Math.abs(target-b) ? -1 : 1;
	}
	public int threeSumClosest(int[] nums, int target) {
		TreeSet<Integer> res = new TreeSet<Integer>();
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++){
			int s = i + 1;
			int e = nums.length - 1;
			TreeSet<Integer> set = new TreeSet<Integer>();
			while(s < e){
				if(nums[s] + nums[e] < target - nums[i]){
					set.add(nums[s] + nums[e]);
					s++;
				}else if(nums[s] + nums[e] > target - nums[i]){
					set.add(nums[s] + nums[e]);
					e--;
				}else{
					return target;
				}
			}
			Integer a = set.ceiling(target - nums[i]);
            Integer b = set.floor(target - nums[i]);
            
            if(a != null && b != null){
            	int t = myComparor(a, b, target - nums[i]);
            	if(t < 0){
            		res.add(a+nums[i]);
            	}else{
            		res.add(b+nums[i]);
            	}
            }else{
            	if(a != null){
            		res.add(a+nums[i]);
            	}else if(b != null){
            		res.add(b+nums[i]);
            	}
            }
		}
		Integer a = res.ceiling(target);
        Integer b = res.floor(target);
        if(a != null && b != null){
        	return myComparor(a, b, target) < 0 ? a : b;
        }else{
        	return a == null ? b : a;
        }

	}

}
