package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q78_1 {
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		//添加时保证有序
		Arrays.sort(nums);
		f(nums, 0, new ArrayList<Integer>(), res);
		return res;
	}

	public void f(int[] nums, int index, List<Integer> path,
			List<List<Integer>> res) {
		
		for (int i = index; i < nums.length; i++) {
			path.add(nums[i]);
			//这里添加一定要new一个，不然后面path删除元素会影响结果集
//			res.add(path);
			res.add(new ArrayList<Integer>(path));
			f(nums, i + 1, path, res);
			path.remove(path.size() - 1);
		}

	}
	
	public List<List<Integer>> subsets1(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		Arrays.sort(nums);
		for (Integer i : nums) {
//			
			
			
//			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
//			for (List<Integer> sub : res) {
//				//这里sub添加后，res会马上改变
//				sub.add(i);
//				tmp.add(sub);
//			}
//			res.addAll(tmp);
			
//			// java.util.ConcurrentModificationException
//			List<List<Integer>> tmp = new ArrayList<List<Integer>>(res);
//			for (List<Integer> sub : tmp) {
//				List<Integer> tt = new ArrayList<Integer>(sub);
//				tt.add(i);
//				tmp.add(tt);
//			}
//			res = tmp;
			
			
			
			//记录本次循环添加的list,一定与res无关，不然ConcurrentModificationException
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for (List<Integer> sub : res) {
				//对于sub建立副本，不然修改sub，res会改变
				List<Integer> list = new ArrayList<Integer>(sub);
				list.add(i);
				tmp.add(list);
			}
			//同步回res
			res.addAll(tmp);
			
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		Q78_1 q = new Q78_1();
		int[] nums = {3,1,2};
		List<List<Integer>> list = q.subsets1(nums);
		System.out.println(list);
	}

}
