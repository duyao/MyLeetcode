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
		for(String[] s : tickets){
			if(!flights.containsKey(s[0])){
				flights.put(s[0], new PriorityQueue<String>());
			}
			flights.get(s[0]).add(s[1]);
		}
		
		
		//http://www.graph-magics.com/articles/euler.php
		//设置一个退回栈就是circle，存放没有相邻接点的点
		//1.从开始节点遍历，将每个有相邻接点的点加入到结果集stack中
		//2.如果当前结点无相邻接点，则将其放入退回栈
		//3.然后在结果集中逆序选取有相邻接点的点作为当前结点
		//4.继续123，直到遍历过所有的边
		//5.最后将结果集并入到退回栈circle中
		Stack<String> circle = new Stack<String>();
		Stack<String> stack = new Stack<String>(); 
		String cur = "JFK";
		for(int i = 0; i < tickets.length; i++){
			while(!flights.containsKey(cur) || flights.get(cur).size() == 0){
				circle.add(cur);
				cur = stack.pop();
			}
			stack.add(cur);
			cur = flights.get(cur).poll();
		}
		//最后一个节点一定是没有邻接点的点，因此要放到退回栈circle中
		circle.add(cur);
		//结果集并入到退回栈中
		while(!stack.isEmpty()){
			circle.add(stack.pop());
		}
		//退回栈的逆序为最终路径
		while(!circle.isEmpty()){
			path.add(circle.pop());
		}
		return path;
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
