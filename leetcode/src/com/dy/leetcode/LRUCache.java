package com.dy.leetcode;

import java.util.HashMap;

public class LRUCache {
	

	class Node {
		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + ", next=" + next
					+ ", prior=" + prior + "]";
		}

		int key;
		int value;
		Node next;
		Node prior;
	}

	private void delete(Node cur) {
		// 把cur删除
		cur.next.prior = cur.prior;
		cur.prior.next = cur.next;
		map.remove(cur.key);

	}

	// 头插，在head之后
	private void add(Node cur) {
		cur.next = head.next;
		cur.prior = head;
		head.next.prior = cur;
		head.next = cur;
		map.put(cur.key,cur);
	}

	private void moveToHead(Node cur) {
		delete(cur);
		add(cur);
	}

	//双向链表，这样才能实现删除末尾不常用的节点
	private Node head;
	private Node tail;
	private int cnt;
	//使用map记录所有的节点信息，这样就能够O(1)取出节点
	private HashMap<Integer, Node> map;

	public LRUCache(int capacity) {
		cnt = capacity;
		// 头尾节点都是空的
		head = new Node();
		tail = new Node();
		head.next = tail;
		head.prior = null;
		tail.prior = head;
		tail.next = null;
		map = new HashMap<Integer, Node>(capacity);

	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node cur = map.get(key);
//			System.out.println("before======" + cur);
			moveToHead(cur);
//			System.out.println("after======" + cur);
			return cur.value;
		}
		return -1;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			delete(map.get(key));
		}
		// 插入
		Node node = new Node();
		node.key = key;
		node.value = value;
		if (map.size() >= this.cnt) {
			// 空间不够，将尾巴删除
			delete(tail.prior);
			

		}
		add(node);
		
	}
	
	private void myPrint(){
		Node cur = head.next;
		int i = 0;
		while(cur != tail){
			System.out.println(i+"-> ("+cur.key+", "+cur.value+")");
			i++;
			cur = cur.next;
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.set(1, 1);
		cache.set(2, 1);
		cache.set(3, 1);
		cache.myPrint();
		System.out.println("cache.get(1);");
		cache.get(90);
		cache.get(2);
		cache.set(4, 1);
		cache.myPrint();

	}
}
