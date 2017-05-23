package com.dy.leetcode;

public class Q61_1 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	//
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0){
			return head;
		}
		ListNode tail = head;
		int cnt = 0;
		while(tail.next != null){
			cnt++;
			tail = tail.next;
		}
		//计算长度
		cnt += 1;
		//算出要移动多少位置
		int x = cnt - k %cnt;
		if(x == 0){
			return head;
		}
		ListNode tmp = head;
		while(--x != 0){
			tmp = tmp.next;
			
		}
		tail.next = head;
		head = tmp.next;
		tmp.next = null;
		return head;
		
	}
	public static void main(String[] args) {
		Q61_1 q = new Q61_1();
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(6);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		head = q.rotateRight(head, 12);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
		
	}

}
