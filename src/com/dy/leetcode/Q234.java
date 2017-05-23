package com.dy.leetcode;

import com.dy.leetcode.Q147.ListNode;

public class Q234 {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		ListNode quick = head;
		ListNode slow = head;
		while (quick != null && quick.next != null) {
			slow = slow.next;
			quick = quick.next.next;
		}
		if (quick != null && quick.next == null) {
			slow = slow.next;
		}
		ListNode head1 = slow;
		slow = head1.next;
		head1.next = null;
		ListNode next = null;
		//后面头插形成新链表
		while(slow != null){
			next = slow.next;
			slow.next = head1;
			head1 = slow;
			slow = next;
		}
		while(head1 != null){
			if(head1.val != head.val){
				return false;
			}
			head1 = head1.next;
			head = head.next;
		}
		return true;

	}
	public static void main(String[] args) {
		ListNode head =new ListNode(1);
		ListNode h1 =new ListNode(1);
		ListNode h2 =new ListNode(3);
//		ListNode h5 =new ListNode(3);
		ListNode h3 =new ListNode(2);
		ListNode h4 =new ListNode(1);
		head.next = h1;
//		h1.next = h2;
//		h2.next = h3;
////		h2.next = h5;
////		h5.next = h3;
//		h3.next = h4;
		Q234 q = new Q234();
		boolean b = q.isPalindrome(head);
		System.out.println(b);
	}

}
