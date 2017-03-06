package com.dy.leetcode;

import java.util.HashSet;

/**
 * Created by amy on 2017/3/6.
 */
public class Q138 {
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }

        @Override
        public String toString() {
            return "RandomListNode{" +
                    "label=" + label +
                    ", next=" + next +
                    ", random=" + random +
                    '}';
        }
    }

    //有问题！！
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }


        //一共遍历3次，
        //第一次，复制节点，且将该节点设为其next
        RandomListNode cur = head;

        while (cur != null) {
            RandomListNode tmp = new RandomListNode(cur.label);
            //新复制的节点插入原节点之后
            tmp.next = cur.next;
            cur.next = tmp;

            cur = tmp.next;

        }
        //第二次，复制其random
        cur = head;
        while (cur != null) {
            //因为新节点就是原节点的后继，所以直接next就能得到
            cur.next.random = cur.random == null ? null : cur.random.next == null ? new RandomListNode(cur.random.label) : cur.random.next;

            cur = cur.next.next;
        }
        //第三次，删去多余节点,并恢复复制节点的关系
        cur = head;
        RandomListNode res = cur.next;
        while (cur != null) {
            //复制节点
            RandomListNode tmp = cur.next;
            //复制节点的next
            RandomListNode tmpnext = tmp.next.next;
            //原节点删除复制节点
            cur.next = cur.next.next;
            //复制节点恢复next
            tmp.next = tmpnext;

            cur = cur.next;
        }
        return res;

    }

    public static void main(String[] args) {
        Q138 q = new Q138();
        RandomListNode root = new RandomListNode(1);
        RandomListNode e = new RandomListNode(2);
        root.next = null;
        root.random = e;
//        e.random = root;

        RandomListNode res =  q.copyRandomList(root);
        System.out.println(res.random);
    }

}
