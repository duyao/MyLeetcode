package com.dy.leetcode;

import com.dy.leetcode.Q100.TreeNode;

public class Q98 {
	//[10,5,15,null,null,6,20]
	public boolean isValidBST(TreeNode root) {
	
        if(root == null){
        	return true;
        }else{
        	boolean b = false;
        	if(root.left != null && root.left.val < root.val 
        			
        			&&root.right!= null && root.right.val > root.val 
        			){
        		b = true;
        	}else if(root.left == null && root.right != null && root.right.val > root.val){
        		b =true;
        	}else if(root.right == null && root.left != null && root.left.val < root.val ){
        		b =true;
        	}
        	
        	return b && isValidBST(root.left) && isValidBST(root.right);
        }
    }

}
