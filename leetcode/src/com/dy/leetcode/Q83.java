package com.dy.leetcode;


public class Q83 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		ListNode next = head.next;
		while(node != null && next != null){
			 while(next.val == node.val){
				 next = next.next;
			 }
			 node.next = next;
			 node = next;
			 next = next.next;
			 
		}
		return head;
	}
}
