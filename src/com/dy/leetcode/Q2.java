package com.dy.leetcode;

public class Q2 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int cnt = 0;
		ListNode cur = new ListNode(0);
		ListNode head = cur;
		while(l1 != null && l2 != null){
			int tmp = cnt + l1.val + l2.val;
			cnt = 0;
			if(tmp >= 10){
				cnt = tmp/10;
				tmp %= 10;
				
			}
			ListNode node = new ListNode(tmp);
			cur.next = node;
			cur = node;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			int tmp = cnt + l1.val;
			cnt = 0;
			if(tmp >= 10){
				cnt = tmp/10;
				tmp %= 10;
			}
			ListNode node = new ListNode(tmp);
			cur.next = node;
			cur = node;
			l1 = l1.next;
		}
		while(l2 != null){
			int tmp = cnt + l2.val;
			cnt = 0;
			if(tmp >= 10){
				cnt = tmp/10;
				tmp %= 10;
			}
			ListNode node = new ListNode(tmp);
			cur.next = node;
			cur = node;
			l2 = l2.next;
		}
		if(cnt != 0){
			ListNode node = new ListNode(cnt);
			cur.next = node;
			cur = node;
		}
		cur.next = null;
		head = head.next;
		return head;
	}
	public static void main(String[] args) {

		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		addTwoNumbers(l1, l2);
	}

}
