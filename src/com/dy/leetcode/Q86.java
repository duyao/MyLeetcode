package com.dy.leetcode;

import com.dy.leetcode.Q147.ListNode;

public class Q86 {
	public ListNode partition(ListNode head, int x) {

		ListNode cur = head;
		ListNode prior = null;
		boolean bhh = false;
		ListNode hh = head;
		ListNode phh = null;
		ListNode del = head;
		while (cur != null) {
			if (!bhh && cur.val >= x) {
				hh = cur;
				phh = prior;
				bhh = true;
			}
			if (cur.val < x && bhh) {
				ListNode tmp = delete(prior);
				if(phh == null){
					tmp.next = hh;
					head = tmp;
					prior = tmp;
				}else{
					tmp.next = hh;
					phh.next = tmp;
					phh = tmp;
				}
				

			}
			prior = cur;
			cur = cur.next;

		}
		return head;

	}

	public ListNode delete(ListNode prior) {
		ListNode del = prior.next;
		prior.next = del.next;
		//??
		return new ListNode(del.val);
	}

	public void myPrint(ListNode res) {
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		System.out.println();
	}

	public ListNode generate(int[] x) {
		ListNode head = new ListNode(x[0]);
		ListNode cur = head;
		for (int i = 1; i < x.length; i++) {
			ListNode tmp = new ListNode(x[i]);
			cur.next = tmp;
			cur = tmp;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] x = { 8, 9, 2, 6, 4, 5, 4, 3, 2, 5, 2 };

		Q86 q = new Q86();
		ListNode head = q.generate(x);
		q.myPrint(head);
		ListNode res = q.partition(head, 5);
		q.myPrint(res);
	}

}
