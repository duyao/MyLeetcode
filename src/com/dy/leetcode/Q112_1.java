package com.dy.leetcode;
import com.dy.leetcode.Q100.TreeNode;


/**
 * Created by amy on 2017/2/16.
 */
public class Q112_1 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }else{
            if(root.left == null && root.right ==null && sum - root.val == 0){
                return true;
            }

            return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum - root.val);
        }

    }
}
