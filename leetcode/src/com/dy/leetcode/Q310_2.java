package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q310_2 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	    if (n == 1) return Collections.singletonList(0);

	    List<Set<Integer>> adj = new ArrayList<>(n);
	    for (int i = 0; i < n; ++i) {
	    	adj.add(new HashSet<Integer>());
	    }
	    for (int[] edge : edges) {
	        adj.get(edge[0]).add(edge[1]);
	        adj.get(edge[1]).add(edge[0]);
	    }

	    List<Integer> leaves = new ArrayList<>();
	    for (int i = 0; i < n; ++i){
	    	if(adj.get(i).size() == 1){
	    		leaves.add(i);
	    	}
	    }
	    
	    while(n > 2){
	    	n -= leaves.size();
	    	//临时存放下次要遍历的叶子
	    	ArrayList<Integer> tleaves = new ArrayList<Integer>();
 	    	for (Integer cur : leaves) {
 	    		//遍历叶子队列中的点
				for (Integer edge : adj.get(cur)) {
					adj.get(edge).remove(cur);
					//次遍历过程中的邻接边，且改变的邻接边个数为1，添加到下次的叶子队列中
					if(adj.get(edge).size() == 1){
						tleaves.add(edge);
					}
				}
			}
 	    	leaves = tleaves;
	    	
	    }
	    return leaves;
	}
}
