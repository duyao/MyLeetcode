package com.dy.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;



public class Q332_2 {
	// [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
	// /Your ["JFK","KUL","NRT","JFK"] isn't even valid, as there's no ticket
	// from KUL to NRT (and it's missing the one from JFK to NRT).

	//这里的flights中只包含有邻居的节点
	Map<String, PriorityQueue<String>> flights;
	//返回值
	LinkedList<String> path;

	public List<String> findItinerary(String[][] tickets) {
		//使用优先队列来记录相邻接点且保证了字典顺序
		flights = new HashMap<String, PriorityQueue<String>>();
		path = new LinkedList<String>();
		if (tickets == null || tickets.length == 0) {
			return path;
		}
		int cnt = 0;
		for(String[] s : tickets){
			if(!flights.containsKey(s[0])){
				flights.put(s[0], new PriorityQueue<String>());
			}
			flights.get(s[0]).add(s[1]);
			cnt++;
		}
		
		Stack<String> stack = new Stack<String>();
//		dfs(stack,"JFK");
		
		Stack<String> tmps = new Stack<String>();
		Stack<String> finals = new Stack<String>();
		String cur = "JFK";
		tmps.add(cur);
		//次数有问题
		while(cnt >= 0){
			PriorityQueue<String> next = flights.get(cur);
			if(next == null || next.size() == 0){
				finals.add(tmps.pop());
				cur = tmps.peek();
			}else{
				cur = next.poll(); 
				tmps.add(cur);
			}
			cnt--;
		}
		while(!tmps.isEmpty()) finals.push(tmps.pop());
		while(!finals.isEmpty()) path.add(finals.pop());
		
		return path;
		
	}
	
	//http://www.graph-magics.com/articles/euler.php
	public void dfs(Stack<String> stack, String cur ){
		//现在栈中添加节点
		stack.add(cur);
		while(!stack.empty()){
			PriorityQueue<String> next = flights.get(cur);
			//访问其所有邻居
			while(next != null && !next.isEmpty()){
				dfs(stack,next.poll());
			}
			//如果没有邻居了，就pop，并且逆序添加到队列中
			if(next == null || next.size() == 0){
				path.addFirst(stack.pop());
				return;
			}
			
			
		}
	}

	

	public static void main(String[] args) {
		Q332_2 q = new Q332_2();
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<String> res = q.findItinerary(tickets);
		for (String string : res) {
			System.out.println(string);
		}
	}

}
