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
	    	//��ʱ����´�Ҫ������Ҷ��
	    	ArrayList<Integer> tleaves = new ArrayList<Integer>();
 	    	for (Integer cur : leaves) {
 	    		//����Ҷ�Ӷ����еĵ�
				for (Integer edge : adj.get(cur)) {
					adj.get(edge).remove(cur);
					//�α��������е��ڽӱߣ��Ҹı���ڽӱ߸���Ϊ1����ӵ��´ε�Ҷ�Ӷ�����
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
