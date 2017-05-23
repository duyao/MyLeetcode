package com.dy.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Q332_1 {
	// [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
	// /Your ["JFK","KUL","NRT","JFK"] isn't even valid, as there's no ticket
	// from KUL to NRT (and it's missing the one from JFK to NRT).

	Map<String, PriorityQueue<String>> flights;
	LinkedList<String> path;

	public List<String> findItinerary(String[][] tickets) {
		flights = new HashMap<>();
		path = new LinkedList<>();
		for (String[] ticket : tickets) {
			if(!flights.containsKey(ticket[0])){
				flights.put(ticket[0], new PriorityQueue<String>());
			}
			flights.get(ticket[0]).add(ticket[1]);
		}
		dfs("JFK");
		return path;
	}

	public void dfs(String departure) {
		PriorityQueue<String> arrivals = flights.get(departure);
		//访问所有的相邻节点
		while (arrivals != null && !arrivals.isEmpty())
			dfs(arrivals.poll());
		//注意是加到队头！
		path.addFirst(departure);
	}

	public static void main(String[] args) {
		Q332_1 q = new Q332_1();
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<String> res = q.findItinerary(tickets);
		for (String string : res) {
			System.out.println(string);
		}
	}

}
