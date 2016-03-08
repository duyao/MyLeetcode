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

	//�����flights��ֻ�������ھӵĽڵ�
	Map<String, PriorityQueue<String>> flights;
	//����ֵ
	LinkedList<String> path;

	public List<String> findItinerary(String[][] tickets) {
		//ʹ�����ȶ�������¼���ڽӵ��ұ�֤���ֵ�˳��
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
		//����һ���˻�ջ����circle�����û�����ڽӵ�ĵ�
		//1.�ӿ�ʼ�ڵ��������ÿ�������ڽӵ�ĵ���뵽�����stack��
		//2.�����ǰ��������ڽӵ㣬��������˻�ջ
		//3.Ȼ���ڽ����������ѡȡ�����ڽӵ�ĵ���Ϊ��ǰ���
		//4.����123��ֱ�����������еı�
		//5.��󽫽�������뵽�˻�ջcircle��
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
		//���һ���ڵ�һ����û���ڽӵ�ĵ㣬���Ҫ�ŵ��˻�ջcircle��
		circle.add(cur);
		//��������뵽�˻�ջ��
		while(!stack.isEmpty()){
			circle.add(stack.pop());
		}
		//�˻�ջ������Ϊ����·��
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
