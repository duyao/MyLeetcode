package com.dy.leetcode;

import com.dy.leetcode.Q147.ListNode;

public class Q19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tmp = head;
		while (n-- > 0) {
			tmp = tmp.next;
		}
		if (tmp == null) {
			return head.next;
		}
		ListNode cur = head;
		while (tmp.next != null) {
			cur = cur.next;
			tmp = tmp.next;
		}
		cur.next = cur.next.next;
		return head;

	}

}
