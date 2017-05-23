package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		f(0, candidates, target, new ArrayList<Integer>(), res);
		System.out.println(res);
		return new ArrayList<List<Integer>>(res);

	}

	public void f(int i, int[] candidates, int target, List<Integer> cur,
			Set<List<Integer>> res) {
		if (target == 0) {
			List<Integer> tmp = new ArrayList<Integer>(cur);
			Collections.sort(tmp);
			res.add(tmp);
		} else {
			for (int j = i; j < candidates.length; j++) {
				cur.add(candidates[j]);
				f(j + 1, candidates, target - candidates[j], cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
	    	
	    	int[]a = new int[]{ 2,5,2,1,2};
	    	Q40 q= new Q40();
	    	q.combinationSum2(a, 5);
	    	Set<List<Integer>> res = new HashSet<List<Integer>>();
            List<Integer> t1 = new ArrayList<Integer>();
            t1.add(1);
            t1.add(7);
            List<Integer> t2 = new ArrayList<Integer>();
            t2.add(7);
            t2.add(1);
//            Collections.sort(t2);
            res.add(t1);
            res.add(t2);
            //顺序不同，元素相同的arrylist是不同的
//            System.out.println(res.size());
            
		}
}
