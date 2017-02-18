package com.dy.leetcode;

import com.dy.leetcode.Q206.ListNode;

/**
 * Created by amy on 2017/2/18.
 */
public class Q24 {


    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }
        ListNode na = head;
        ListNode nb = head.next.next;
        ListNode before = null;
        head = na.next;
        while(na != null){

            ListNode tmp = na.next;
            //先删除
            na.next = nb;

            //再插入
            tmp.next = na;



            if(before != null){
                before.next = tmp;

            }
            before = na;

            //更新
            na = nb;
            if(na == null || na.next == null){
                break;
            }else{
                nb = na.next.next;
            }
        }
        return head;
    }
}
