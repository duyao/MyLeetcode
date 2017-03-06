package com.dy.leetcode;

import com.dy.leetcode.Q100.*;

/**
 * Created by amy on 2017/3/6.
 */
public class Q114 {
    public void flatten(TreeNode root) {


    }

    public void pre(TreeNode root, TreeNode res) {


        if (root != null) {
            TreeNode tmp = new TreeNode(root.val);
            res.right = tmp;

            pre(tmp.left, tmp);
            pre(tmp.right, tmp);
        }
    }
}
