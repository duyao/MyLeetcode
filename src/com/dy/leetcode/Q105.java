package com.dy.leetcode;

import com.dy.leetcode.Q100.*;

/**
 * Created by think on 2017-03-19.
 */
public class Q105 {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        // write your code here
//        if (preorder.length == 0 || inorder.length == 0) {
//            return null;
//        }
//        return f(0, 0, preorder.length, preorder, inorder);
//    }
//
//    public TreeNode f(int root, int low, int high, int[] preorder, int[] inorder) {
//        if (root >= preorder.length || high > preorder.length) {
//            return null;
//
//        }
//
//        TreeNode node = new TreeNode(preorder[root]);
//        int i = low;
//        for (; i < high; i++) {
//            if (preorder[root] == inorder[i]) {
//                break;
//            }
//        }
//        TreeNode left = f(root + 1, low, i, preorder, inorder);
//        TreeNode right = f(root + i - low + 1, i + 1, high, preorder, inorder);
//        node.left = left;
//        node.right = right;
//        return node;
//
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return  null;
        }
        return f(preorder, inorder, 0, 0, inorder.length);
    }

    public TreeNode f(int[] preorder, int[] inorder, int pre, int inl, int inr) {

        //这里所有的区间都是左开右闭
        if (pre >= preorder.length || inl >= inr) {
            return null;
        }
        int r = -1;
        //寻找根在中序的位置
        for (int i = inl; i < inr; i++) {
            if (inorder[i] == preorder[pre]) {
                r = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[pre]);
        //左子树的根节点就是pre的后面一个
        root.left = f(preorder, inorder, pre + 1, inl, r);
        //右子树的根节点就是pre+左子树的长度的后面一个
        root.right = f(preorder, inorder, pre + (r - inl) + 1, r + 1, inr);
        return root;
    }

    public static void main(String[] args) {
        int a[] = {1, 2};
        int b[] = {1, 2};
        Q105 q = new Q105();
        q.buildTree(a, b);
    }
}
