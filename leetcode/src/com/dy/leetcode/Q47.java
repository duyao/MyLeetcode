package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q47 {
	//µÝ¹é
	public List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		f(nums, 0, new ArrayList<Integer>(), res);
		return new ArrayList<List<Integer>>(res); 
		
	}
	
	public void f(int[] nums, int index, List<Integer> cur,Set<List<Integer>> res){
		if(index == nums.length){
			res.add(new ArrayList<Integer>(cur));
			return ;
		}
		for (int i = 0; i <= cur.size(); i++) {
			List<Integer> tmp = new ArrayList<Integer>(cur);
			tmp.add(i,nums[index]);
			f(nums, index+1, tmp, res);
			tmp.remove(tmp.size()-1);
		}
	}
	
	//·ÇµÝ¹é
	public List<List<Integer>> permuteUnique1(int[] nums) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < nums.length; i++) {
			Set<List<Integer>> tres = new HashSet<List<Integer>>(res);
			for (List<Integer> list : res) {
				List<Integer> cur = new ArrayList<Integer>(list);
				cur.add(nums[i]);
				tres.add(cur);
			}
			res = tres;
		}
		
		return new ArrayList<List<Integer>>(res); 
		
	}
	
	
	public static void main(String[] args) {
		Q47 q = new Q47();
		int[] nums = {1,2,2};
		List<List<Integer>> res = q.permuteUnique(nums);
		System.out.println(res);
	}
	

}
