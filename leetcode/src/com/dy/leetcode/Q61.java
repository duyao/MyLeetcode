package com.dy.leetcode;

public class Q61 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		int cnt = getLen(head);
		k %= cnt;
		if (k == 0) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null) {
			if (slow != head || fast != head) {
				slow = slow.next;
				fast = slow;
			}

			for (int i = 0; i < k; i++) {
				fast = fast.next;
			}
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;

	}

	public int getLen(ListNode head) {
		int cnt = 0;
		ListNode cur = head;
		while (cur != null) {
			cnt++;
			cur = cur.next;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Q61 q = new Q61();
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

		head = q.rotateRight(head, 11);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

}
