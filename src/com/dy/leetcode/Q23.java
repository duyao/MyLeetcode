package com.dy.leetcode;

import com.dy.leetcode.Q147.ListNode;

public class Q23 {
	public ListNode mergeKLists(ListNode[] lists) {
//		if(lists == null || lists.length == 0){
//            return null;
//        }
//		
//		int k = lists.length-1;
//		while(k > 0){
//			int cnt = 0;
//			for (int i = 0; i <= k/2; i += 2) {
//				if(i + 1 <= k){
//					lists[cnt++] = merge(lists[i], lists[i+1]);
//				}else{
//					lists[cnt++] = lists[k];
//				}
//			}
//			k /= 2;
//		}
//		return lists[0];
		return sort(lists,0 ,lists.length-1);
		
	}
	
	private ListNode sort(ListNode[] lists, int s ,int e){
		if(s < e){
			int mid = (s + e) / 2;
			ListNode head1 = sort(lists, s, mid);
			ListNode head2 = sort(lists, mid+1, e);
			return merge(head1, head2);
			
		}else if(s == e){
			return lists[s];
		}else{
			return null;
		}
	}
	
	private ListNode merge(ListNode a, ListNode b){
		ListNode head = new ListNode(0);
		ListNode cur = head.next;
		while(a != null && b != null){
			if(a.val < b.val){
				cur = a;
				a = a.next;
			}else{
				cur = b;
				b = b.next;
			}
			cur = cur.next;
		}
		while(a != null){
			cur = a;
			a = a.next;
			cur = cur.next;
		}
		while(b != null){
			cur = b;
			b = b.next;
			cur = cur.next;
		}
		cur = null;
		return head.next;
		
	}

	public static void main(String[] args) {
		

	}

}
