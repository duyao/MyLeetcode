package com.dy.leetcode;

public class Q237 {

	public class ListNode {
		int value;
		ListNode next;

		public ListNode(int value) {
			this.value = value;
		}
	}

	//ɾ�������ڵ�
	//������Ѷ����ڲ�û�и����ýڵ������
	//���ֻ�ܲ��ø��Ƿ�ʽ��������ǰ���ĺ��ֵ���ǵ���ǰ��㣬Ȼ��ɾ����̵ĺ��
	//�����Ŀ����˵������������һ���ڵ�
	public void deleteNode(ListNode node) {
		ListNode del = node.next;
		//����ֵ
		node.value = del.value;
		//ɾ�����
		node.next = del.next;
		
	}
}
