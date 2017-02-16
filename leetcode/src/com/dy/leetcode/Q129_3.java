package com.dy.leetcode;
import com.dy.leetcode.Q100.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amy on 2017/2/16.
 */
public class Q129_3 {
    public int sumNumbers(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        visit(root, new StringBuffer(), res);
        int sum = 0;
        for (Integer i: res
             ) {
            sum += i;

        }
        return sum;


    }
    public void visit(TreeNode root, StringBuffer sb, List<Integer> res){
        if(root != null){
            sb.append(root.val);

            if(root.left == null && root.right == null){
                res.add(Integer.valueOf(sb.toString()));

            }


            visit(root.left, sb, res);
            visit(root.right, sb, res);

            sb.deleteCharAt(sb.length()-1);


        }
    }
    public static void main(String[] args) {
        //[3,4,4,5,null,6,5,6,null,null,null]
        Q100.TreeNode root = new Q100.TreeNode(0);
        Q100.TreeNode t2 = new Q100.TreeNode(1);
//        TreeNode t3 = new TreeNode(0);
//        TreeNode t4 = new TreeNode(0);
//        TreeNode t5 = new TreeNode(0);
//        TreeNode t6 = new TreeNode(0);
//        TreeNode t7 = new TreeNode(1);
        root.left = t2;
//        root.right = t3;
//        t2.left = t4;
//        t3.left = t7;
//        t3.right = t5;
//        t4.left = t6;

        Q129_3 q = new Q129_3();
        System.out.println(q.sumNumbers(root));
    }
}
