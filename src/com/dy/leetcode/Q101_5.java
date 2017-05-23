package com.dy.leetcode;

import com.dy.leetcode.Q100.TreeNode;

/**
 * Created by amy on 2017/3/2.
 */
public class Q101_5 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (root.left == null && root.right != null || root.right == null && root.left != null) {
                return false;
            }else if(root.left == null && root.right == null){
                return true;
            }
            return root.left.val == root.right.val && isSymmetric(root.left) && isSymmetric(root.right);


        }
    }

    public static void main(String[] args) {
        //[3,4,4,5,null,null,5,6,null,null,6]
        TreeNode root = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(6);
        root.left = t2;
        root.right = t3;
        t2.right = t4;
        t3.left = t5;
//        t4.left = t6;
//        t5.right = t7;
        //3445**56**6****
        Q101_5 q = new Q101_5();
        System.out.println(q.isSymmetric(root));
    }
}
