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
		// ��curɾ��
		cur.next.prior = cur.prior;
		cur.prior.next = cur.next;
		map.remove(cur.key);

	}

	// ͷ�壬��head֮��
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

	//˫��������������ʵ��ɾ��ĩβ�����õĽڵ�
	private Node head;
	private Node tail;
	private int cnt;
	//ʹ��map��¼���еĽڵ���Ϣ���������ܹ�O(1)ȡ���ڵ�
	private HashMap<Integer, Node> map;

	public LRUCache(int capacity) {
		cnt = capacity;
		// ͷβ�ڵ㶼�ǿյ�
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
		// ����
		Node node = new Node();
		node.key = key;
		node.value = value;
		if (map.size() >= this.cnt) {
			// �ռ䲻������β��ɾ��
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
