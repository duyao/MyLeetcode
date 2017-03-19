package com.dy.leetcode;

import com.dy.leetcode.Q100.*;
import com.dy.leetcode.Q2.*;


/**
 * Created by amy on 2017/3/5.
 */
public class Q109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return addNode(head, null);


    }

    public TreeNode addNode(ListNode head, ListNode tail) {
        //边界条件是这个队列中只有一个元素
        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != tail && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = addNode(head, slow);
        root.right = addNode(slow.next, tail);
        return root;


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        Q109 q = new Q109();
        TreeNode root = q.sortedListToBST(l1);
        System.out.println(root.val);

    }
}
