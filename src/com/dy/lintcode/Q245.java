package com.dy.lintcode;

/**
 * Created by amy on 2017/5/23.
 */

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

}

public class Q245 {


    public static boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T2 == null || T1 == null && T2 == null) {
            return true;
        } else if (T1 == null) {
            return false;
        } else {
            if (T1.val != T2.val) {
                return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
            } else {
                if (isSame(T1, T2)) {
                    return true;
                } else {
                    return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
                }
            }
        }


    }

    public static boolean isSame(TreeNode T1, TreeNode T2) {
        if (T1 == null && T2 != null || T2 == null && T1 != null) {
            return false;
        } else if (T1 == null && T2 == null) {
            return true;
        } else if (T1.val != T2.val) {
            return false;
        } else {
            return isSame(T1.left, T2.left) && isSame(T1.right, T2.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;

        TreeNode rroot = new TreeNode(1);
        TreeNode tt3 = new TreeNode(2);
        TreeNode tt4 = new TreeNode(3);
        rroot.left = tt3;
        root.right = tt4;

        System.out.println(isSubtree(root, rroot));

    }
}
