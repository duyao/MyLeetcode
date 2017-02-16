package com.dy.leetcode;
import com.dy.leetcode.Q100.TreeNode;

/**
 * Created by amy on 2017/2/16.
 */
public class Q129_2 {
    static int sum = 0;
    public int sumNumbers(TreeNode root) {

        visit(root, new StringBuffer());
        return sum;


    }
    public void visit(TreeNode root, StringBuffer sb){
        if(root != null){
            sb.append(root.val);

            if(root.left == null && root.right == null){
                sum += Integer.valueOf(sb.toString());

            }

            visit(root.left, sb);
            visit(root.right, sb);

            sb.deleteCharAt(sb.length()-1);

        }
    }
    public static void main(String[] args) {
        //[3,4,4,5,null,6,5,6,null,null,null]
        TreeNode root = new TreeNode(0);
        TreeNode t2 = new TreeNode(1);
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

        Q129_2 q = new Q129_2();
        System.out.println(q.sumNumbers(root));
    }
}
