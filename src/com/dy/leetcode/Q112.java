package com.dy.leetcode;

import com.dy.leetcode.Q100.TreeNode;

import java.util.Stack;

/**
 * Created by amy on 2017/2/15.
 */
public class Q112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        boolean b = visit(root, stack, 0, sum);
        return b;
    }

    public boolean visit(TreeNode root, Stack<TreeNode> stack, int cnt, int sum) {
        boolean bb = false;
        if (root != null) {
            if (stack.empty()) {
                stack.push(root);
                cnt += root.val;

                //只有一个节点的情况
                if(root.left == null && root.right == null && cnt == sum){
                    bb = true;
                }

            } else {

                TreeNode parent = stack.peek();

                //叶子节点
                if (root.left == null && root.right == null) {

                    cnt += root.val;
                    if (cnt == sum) {
                        return true;
                    } else {
                        //叶子节点，需要减去
                        cnt -= root.val;
                    }

                } else {
//                    System.out.println("root = "+root+", l = "+parent.left+" , r = "+parent.right);
//                    System.out.println(parent.left == root);
//                    System.out.println(parent.right == root);
                    while (parent.left != root && parent.right != root) {
                        TreeNode tmp = stack.pop();
                        //这里不需要修改cnt的值，因为cnt是每次递归进行传递，递归到上一层，就会自动修改为原值
                        //cnt -= tmp.val;
                        parent = stack.peek();
                    }
                    stack.push(root);
                    cnt += root.val;
                }
            }


            //这里返回必须在该层，因为这是对于遍历的返回结果
            //如果移动上一层的栈非空返回就会错误
            //返回值是或，有一个为真就说明找到了
            return bb  || visit(root.left, stack, cnt, sum) || visit(root.right, stack, cnt, sum);

        }

        return false;


    }

    public static void main(String[] args) {
        //[3,4,4,5,null,6,5,6,null,null,null]
        TreeNode root = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
//        TreeNode t3 = new TreeNode(4);
//        TreeNode t4 = new TreeNode(5);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(6);
        root.left = t2;
//        root.right = t3;
//        t2.left = t4;
//        t3.left = t7;
//        t3.right = t5;
//        t4.left = t6;

        Q112 q = new Q112();
        boolean b = q.hasPathSum(root, 7);
        System.out.println(b);
    }
}
