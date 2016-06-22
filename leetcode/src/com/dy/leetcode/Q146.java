package com.dy.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Q146 {
	class Node{
		int value;
		int cnt;
	}
	class myComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			
			return Integer.compare(o1.cnt, o2.cnt);
		}
		
	}
	public static class LRUCache {
		
		TreeMap<Integer, Node> map;
		int count;
		
	    public LRUCache(int capacity) {
	    	this.count = capacity;
	        map = new TreeMap<Integer,Node>();
	        
	        
	        
	        
	        
	    }
	    
	    public int get(int key) {
	    	
	        
	    }
	    
	    public void set(int key, int value) {
	    	
	        
	    }
	}
	public static void main(String[] args) {
		HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		map1.put(1,1);
		HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
		map1.put(1,1);
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer,Integer>>();
		map.put(1, map1);
		map.put(1, map2);
		System.out.println(map.size());
	}
	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
