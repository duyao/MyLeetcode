package com.dy.leetcode;

public class Q206 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseList(ListNode head) {
		if(head != null)
		{
			ListNode prior = head;
			ListNode cur = head.next;
			ListNode next = null;
			while (cur != null) {
				next = cur.next;
				cur.next = prior;
				prior = cur;
				cur = next;
			}
			head.next = null;
			return prior;
		}else{
			return head;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(3);
		head.next = l2;
		l2.next = l3;
		ListNode res = reverseList(head);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
}
