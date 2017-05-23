package com.dy.leetcode;

import com.dy.leetcode.Q100.TreeNode;

import java.util.*;

/**
 * Created by amy on 2017/3/3.
 */
public class Q107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode tail = root;
        LinkedList<TreeNode> queue = new LinkedList<>();
        //因为不是图，所以不会重复遍历
        //HashSet<TreeNode> vis = new HashSet<>();
        List<Integer> curList = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.remove();
                //vis.add(cur);
                curList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(new ArrayList<>(curList));
            curList.clear();

        }

        //res.add(new ArrayList<>(curList));
        Collections.reverse(res);
        System.out.println(res);
        return res;

    }

    public static void main(String[] args) {

        Q107 q = new Q107();
        //[3,4,4,5,null,null,5,6,null,null,6]
        TreeNode root = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(10);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(12);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t3.right = t5;
        t4.left = t6;
        t5.right = t7;
        q.levelOrderBottom(root);


    }
}
