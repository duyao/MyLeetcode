package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q96 {
	static class Tree {
		int value;
		Tree left;
		Tree right;

		Tree(int v) {
			this.value = v;
		}
	}

	public int numTrees(int n) {
		//全排列，然后很据排列建树，判断每个树是否相同
		//如何判断两个树是否全相同？
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < n; i++) {
			List<List<Integer>> tres = new ArrayList<List<Integer>>();
			for (List<Integer> list : res) {
				for (int j = 0; j <= list.size(); j++) {
					List<Integer> tlist = new ArrayList<Integer>(list);
					tlist.add(j, i + 1);
					tres.add(tlist);
				}
			}
			res = tres;
		}
		
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				
			}
		}
		System.out.println(res);
		return res.size();

	}
	
	public boolean buildTree(List<Integer> list){
		Tree root = new Tree(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			Tree cur = root;
			while(cur.left != null || cur.right != null){
				if(list.get(i) < cur.value){
					cur = cur.left;
				}else{
					cur = cur.right;
				}
			}
			
		}
		return true;
	}

	public static void main(String[] args) {
		Q96 q = new Q96();
		int x = q.numTrees(4);
		System.out.println(x);
		
		
	}

}
