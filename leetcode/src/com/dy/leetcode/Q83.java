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
		if(head != null){
			
			ListNode node = head;
			ListNode next = head.next;
			while(node != null && next != null){
				//while(node != null && next != null)防止出现11的情况
				while(node != null && next != null && next.val == node.val){
					next = next.next;
				}
				node.next = next;
				node = next;
				//if(next != null)防止出现11的情况
				if(next != null){
					next = next.next;
				}
			}
			//node.next = null;
		}
		return head;
	}
}
