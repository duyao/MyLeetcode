package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q120 {
	public int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0){
			return 0;
		}
		if(triangle.size() > 1){
			for(int i = triangle.size()-2; i >= 0; i--){
				List<Integer> list = triangle.get(i);
				for(int j = 0; j < list.size(); j++){
					int x = list.get(j);
					x += Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
					list.set(j, x);
				}
				
			}
			
		}
		
		return triangle.get(0).get(0);
	}
	
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(12);
		list2.add(2);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(9);
		list3.add(1);
		list3.add(8);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(1);
		list4.add(4);
		list4.add(7);
		list4.add(1);
		List<List<Integer>>  res = new ArrayList<List<Integer>>();
		res.add(list1);
		res.add(list2);
		res.add(list3);
		res.add(list4);
		Q120 q = new Q120();
		int x = q.minimumTotal(res);
		System.out.println(x);
		
	}

}
