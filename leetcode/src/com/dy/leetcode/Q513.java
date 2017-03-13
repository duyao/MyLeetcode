package com.dy.leetcode;

import com.dy.leetcode.Q100.*;

import java.util.LinkedList;

/**
 * Created by amy on 2017/3/7.
 */
public class Q513 {
    public int findBottomLeftValue(TreeNode root) {

        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode tail = root;
        int res = root.val;
        while (!list.isEmpty()) {

            TreeNode cur = list.pop();
            if (cur.left != null) {
                list.add(cur.left);
            }
            if (cur.right != null) {
                list.add(cur.right);
            }
            if (!list.isEmpty() && cur == tail) {
                tail = list.getLast();
                res = list.isEmpty() ? res : list.getFirst().val;
            }
        }
        return res;

    }
}
