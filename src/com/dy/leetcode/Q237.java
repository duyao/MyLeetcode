package com.dy.leetcode;

public class Q237 {

	public class ListNode {
		int value;
		ListNode next;

		public ListNode(int value) {
			this.value = value;
		}
	}

	//删除给出节点
	//问题的难度在于并没有给出该节点的先驱
	//因此只能采用覆盖方式，即将当前结点的后继值覆盖到当前结点，然后删除后继的后继
	//因此题目中有说明不会给出最后一个节点
	public void deleteNode(ListNode node) {
		ListNode del = node.next;
		//覆盖值
		node.value = del.value;
		//删除后继
		node.next = del.next;
		
	}
}
