package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q78 {
	public List<List<Integer>> subsets(int[] S) {
	    Arrays.sort(S);
	    //所有的结果数是2^n
	    //<<是左移
	    int totalNumber = 1 << S.length;
	    List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
	    //结果所有数字的二进制表示
	    for (int i=0; i<totalNumber; i++) {
	        List<Integer> set = new LinkedList<Integer>();
	        for (int j=0; j<S.length; j++) {
//	        	System.out.println("i="+i+",j="+j+",i & 1<<j="+(i & (1<<j)));
	            //对于每个i都把其二进制中的1添加进来
	        	//因此把1不停的左移，就能筛选出所有的
	        	if ((i & (1<<j)) != 0) {
	                set.add(S[j]);
	            }
	        }
	        collection.add(set);
	    }
	    return collection;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Q78 q = new Q78();
		q.subsets(nums);
	}
	

}
