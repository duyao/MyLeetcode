package com.dy.leetcode;
import com.dy.leetcode.Q100.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amy on 2017/2/16.
 */
public class Q113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> res = new ArrayList<>();
        visit(root, new ArrayList<>(), sum, res);
        return  res;
    }
    public void visit(TreeNode root, List<Integer> list,  int sum, List<List<Integer>> res) {
        if(root != null){
            list.add(root.val);

            if(root.left == null && root.right == null && sum - root.val == 0 ){
                res.add(new ArrayList<>(list));
            }


            visit(root.left, list, sum - root.val, res);
            visit(root.right, list, sum - root.val, res);

            list.remove(list.size()-1);

        }

    }

    public static void main(String[] args) {
        //[3,4,4,5,null,6,5,6,null,null,null]
        TreeNode root = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(4);
//        TreeNode t4 = new TreeNode(2);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(3);
//        TreeNode t7 = new TreeNode(5);
        root.left = t2;
        root.right = t3;
//        t2.left = t4;
//        t3.left = t7;
//        t3.right = t5;
//        t4.left = t6;

        Q113 q = new Q113();
        List<List<Integer>> res = q.pathSum(root, 7);
        System.out.println(res);
    }
}
