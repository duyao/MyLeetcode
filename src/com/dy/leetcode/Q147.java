package com.dy.leetcode;

public class Q147 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		
		ListNode cur = head.next;
		ListNode unsorted = cur.next;
		if(cur.val < head.val){
			head.next = unsorted;
			cur.next = head;
			head = cur;
		}
		cur = head.next.next;
		head.next.next = null;
		while (cur != null) {
			unsorted = cur.next;
			cur.next = null;
			if (cur.val < head.val) {
//				head.next = cur.next;
				cur.next = head;
				head = cur;
			} else {
				boolean flag = false;
				ListNode prior = head;
				ListNode tmp = head.next;
				while (tmp != null) {
					if (cur.val < tmp.val) {
						cur.next = tmp;
						prior.next = cur;
						flag = true;
						break;
					}
					prior = tmp;
					tmp = tmp.next;
				}
				// tmp == null
				if (!flag) {
					prior.next = cur;
					cur.next = null;
				}

			}

			cur = unsorted;
		}
		return head;

	}

	public static void main(String[] args) {
		ListNode head = new ListNode(9);
		ListNode l1 = new ListNode(-9);
		ListNode l2 = new ListNode(87);
		ListNode l3 = new ListNode(10);
		ListNode l4 = new ListNode(115);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		Q147 q = new Q147();
		head = q.insertionSortList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

}
