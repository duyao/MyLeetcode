package com.dy.leetcode;



public class Q148 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	public ListNode sortList(ListNode head) {
		return mergeSort(head);

	}

	public ListNode merge(ListNode a, ListNode b) {
		System.out.println("==merge a==");
		myPrint(a);
		System.out.println("==merge b==");
		myPrint(b);
		ListNode head = new ListNode(0);
		ListNode cur = head;
		
		while(a != null && b != null){
			if(a.val < b.val){
				cur.next = a;
				a = a.next;
			}else{
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}
		while(a != null){
			cur.next = a;
			cur =cur.next;
			a = a.next;
		}
		while(b != null){
			cur.next = b;
			cur = cur.next;
			b = b.next;
		}
//		a =  head.next;
		System.out.println("==merge result==");
		myPrint(head.next);
		return head.next;

	}

	public ListNode mergeSort(ListNode list) {
//		System.out.println("==mergeSort==");
//		myPrint(list);
		if(list == null || list.next == null){
			return list;
		}

		ListNode a = list;
		ListNode b = a;
		while (b != null && b.next != null && b.next.next !=null) {
			a = a.next;
			b = b.next.next;
		}
		b = a.next;
		a.next = null;
		
		ListNode l1 = mergeSort(list);
		ListNode l2 =mergeSort(b);
		
		return merge(l1,l2);


	}
	public void myPrint(ListNode head){
		while (head != null) {
			System.out.print(head.val+" -> ");
			head = head.next;
		}
		System.out.println();
		
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
//		l3.next = l4;
		Q148 q = new Q148();
		ListNode x = q.sortList(head);
		q.myPrint(x);

	}

}
