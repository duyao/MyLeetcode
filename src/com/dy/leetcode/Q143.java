package com.dy.leetcode;

import java.util.Stack;

public class Q143 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	public void reorderList(ListNode head) {
		if(head == null || head.next == null){
			return ;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode cur = head;
		while(cur != null){
			stack.add(cur);
			cur = cur.next;
		}
		
		cur = head;
		ListNode next = head.next;
		while(true){
//			
//			1234
//			4321
//			123
//			321
			
			ListNode node = stack.peek();
			if(node == cur){
				cur.next = null;
				return;
			}
			else if(node == next){
				next.next = null;
				return;
			}
			
			node.next = next;
			cur.next = node;
			cur = next;
			next = cur.next;
			stack.pop();
			
		}
    }
	
	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		Q143 q = new Q143();
		q.reorderList(n1);
		while(n1 != null){
			System.out.println(n1.val+",");
			n1 = n1.next;
		}
	}
}
