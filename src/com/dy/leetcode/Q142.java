package com.dy.leetcode;

public class Q142 {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		//两次开始要一致
		ListNode slow = head;
		ListNode quick = head;
		while (quick != null) {
			//先移动，再判断
			slow = slow.next;
			if (quick.next != null) {
				quick = quick.next.next;
			} else {
				return null;
			}

			if (slow == quick) {
				quick = head;
				while (quick != slow) {
					quick = quick.next;
					slow = slow.next;
				}
				return quick;

			}

		}
		return null;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n1;
		ListNode res = detectCycle(head);
		System.out.println(res.val);
	}

}
