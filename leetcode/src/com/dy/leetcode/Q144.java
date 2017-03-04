package com.dy.leetcode;

import com.dy.leetcode.Q100.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by amy on 2017/3/3.
 */
public class Q144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        //上次访问的节点
        TreeNode last = root;
        stack.push(root);
        res.add(root.val);//先序遇到节点就访问
        while (!stack.isEmpty()) {
            //当前节点
            TreeNode cur = stack.peek();
            //cur的左右都是不是last，左入
            if (cur.left != null && cur.left != last && cur.left != last) {
                stack.push(cur.left);
                res.add(cur.left.val);//先序遇到节点就访问
            }
            //cur的左是last或cur的左空，但是cur右不是，右ru
            else if ( cur.right != null && cur.right != last && (cur.left == null || cur.left == last) ) {
                stack.push(cur.right);
                res.add(cur.right.val);//先序遇到节点就访问

            }
            //其他，cur出
            else {
                last = stack.pop();
            }
        }

        System.out.println(res);
        return res;

    }

    public static void main(String[] args) {

        Q144 q = new Q144();
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
//		t2.left = t4;
//        t2.right = t5;
//		t4.left = t6;
//		t5.right = t7;
        q.preorderTraversal(root);

    }
}
