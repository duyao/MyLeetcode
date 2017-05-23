package com.dy.leetcode;

public class Q141 {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
//		boolean b = true;
		ListNode slow = head;
		ListNode quick = head.next;
		while (quick != null) {
			if (slow == quick) {
				return true;
			}
			slow = slow.next;
			if(quick.next != null){
				quick = quick.next.next;
			}else{
				return false;
			}

		}
		return false;

	}

}
