package com.dy.leetcode;

public class Q206_1 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	
	public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}else{
			ListNode node = reverseList(head.next);
			//���ﷴתʹ��head��������node��
			//node ֻ����������
			//�÷�
			head.next.next = head;
			//ȥ��ԭ����ָ��
			head.next = null;
			return node;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		head.next = null;
		l2.next = l3;
		ListNode res = reverseList(head);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
}
