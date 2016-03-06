package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q332 {
	//[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
	///Your ["JFK","KUL","NRT","JFK"] isn't even valid, as there's no ticket from KUL to NRT (and it's missing the one from JFK to NRT).
	public static class Node {
		String val;
		ArrayList<String> next;
		

		public Node(String val) {
			this.val = val;
			this.next = new ArrayList<String>();
		}
	}

	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<String>();
		if (tickets == null || tickets.length == 0) {
			return res;
		}
		// 已经访问过该边的集合
		HashSet<String> visit = new HashSet<String>();
		HashMap<String, Node> nodes = new HashMap<String, Node>();
		for (int i = 0; i < tickets.length; i++) {

			if (!nodes.isEmpty() && nodes.containsKey(tickets[i][0])) {
				Node node = nodes.get(tickets[i][0]);
				node.next.add(tickets[i][1]);
			} else {
				Node node = new Node(tickets[i][0]);
				node.next.add(tickets[i][1]);
				nodes.put(node.val, node);
			}
		}

		for (String form : nodes.keySet()) {
			Collections.sort(nodes.get(form).next);
		}

		res.add("JFK");
		dfs(nodes.get("JFK"), visit, res, nodes);
		return res;

	}

	public static void dfs(Node cur, HashSet<String> visit, List<String> res,
			HashMap<String, Node> nodes) {
		if(cur == null){
			return;
		}
		System.out.println("Cur"+cur.val);
		for (int i = 0; i < cur.next.size(); i++) {
			if (!visit.contains(cur.val + cur.next.get(i))) {
				res.add(cur.next.get(i));
				visit.add(cur.val + cur.next.get(i));
				dfs(nodes.get(cur.next.get(i)), visit, res, nodes);
			}
		}

	}

	public static void main(String[] args) {
		Q332 q = new Q332();
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}} ;
		List<String> res = q.findItinerary(tickets);
		for (String string : res) {
			System.out.println(string);
		}
	}

}
