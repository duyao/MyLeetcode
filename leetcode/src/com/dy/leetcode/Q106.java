package com.dy.leetcode;

import com.dy.leetcode.Q100.*;

/**
 * Created by think on 2017-03-19.
 */
public class Q106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        //初始，根的位置在最后
        return f(postorder, inorder, postorder.length-1, 0, inorder.length);
    }

    public TreeNode f(int[] postorder, int[] inorder, int post, int inl, int inr) {

        //这里所有的区间都是左开右闭
        if (post >= postorder.length || inl >= inr) {
            return null;
        }
        int r = -1;
        //寻找根在中序的位置
        for (int i = inl; i < inr; i++) {
            if (inorder[i] == postorder[post]) {
                r = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[post]);
        //左子树的根节点就是post减去右子树长度的前一个
        root.left = f(postorder, inorder, post - (inr - r - 1) - 1, inl, r);
        //右子树的根节点就是pre的前一个
        root.right = f(postorder, inorder, post - 1, r + 1, inr);
        return root;
    }
}
