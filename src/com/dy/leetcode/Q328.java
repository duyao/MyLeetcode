package com.dy.leetcode;

public class Q328 {

	  //Definition for singly-linked list.
	  public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	 
	public static ListNode oddEvenList(ListNode head) {
		if(head != null && head.next != null){
			ListNode odd = head;
			ListNode even = head.next;
			ListNode head2 = even;
			while(odd != null && even != null){
				if(even.next != null){
					odd.next = even.next;
					odd = odd.next;
				}else{
					break;
				}
				if(odd.next != null){
					even.next = odd.next;
					even = even.next;
				}else{
					break;
				}
				
			}
			odd.next = head2;
			even.next = null;
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		head.next = l2;
		l2.next = l3;
		l3.next = null;
		l4.next = null;
		ListNode res = oddEvenList(head);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
		
		
	}
}