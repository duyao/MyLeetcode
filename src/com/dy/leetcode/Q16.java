package com.dy.leetcode;

import java.util.TreeSet;

public class Q16 {
	public int myComparor(int a, int b, int target){
		return Math.abs(target-a) < Math.abs(target-b) ? -1 : 1;
	}
    public int threeSumClosest(int[] nums, int target) {
        
    	TreeSet<Integer> res = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
        	
        	TreeSet<Integer> set = new TreeSet<Integer>();
            for(int j = i+1; j < nums.length; j++){
            	for(int k = j +1; k < nums.length; k++){
            		if(nums[k] + nums[j] + nums[i] == -274){
            			System.out.println(nums[k] +","+ nums[j] +","+ nums[i]);
            		}
            		set.add(nums[k] + nums[j]);
            	}
            }
            if(i == 2){
            	System.out.println();
            }
            if(set.contains(target - nums[i])){
            	return target;
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
            if(res.contains(-274)){
        		System.out.println("CUR"+i);
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
    
    public static void main(String[] args) {
		int[] nums = {87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};
		Q16 q = new Q16();
		int a = -275;
		int x = q.threeSumClosest(nums, a);
		System.out.println("x"+x);
		
 	}

}
