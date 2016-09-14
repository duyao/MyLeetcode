package com.dy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dy.leetcode.Q100.TreeNode;

public class Q95 {
	public List<TreeNode> generateTrees(int n) {
		if(n == 0){
			return null;
		}
		//1.���������������
		List<List<Integer>> list = getList(n);
		//2.����������ϲ�����
		Set<TreeNode> set = new HashSet<TreeNode>();
		//3.���ݶ������е����ж��Ƿ����ظ�
		//�жϷ����Ǳ��������ж��Ƿ����
		Set<ArrayList<Integer>> tree = new HashSet<ArrayList<Integer>>();
		for (List<Integer> tlist : list) {
			TreeNode root = buildTree(tlist);
			// �Լ������Ķ���hashcode��û�б���д����˼�ʹ����ͬ��ôֵҲ��ͬ
//			System.out.println("tree->" + root.hashCode());
			ArrayList<Integer> travelList = new ArrayList<Integer>();
			travel(root, travelList);
			if (!tree.contains(travelList)) {
				set.add(root);
				tree.add(travelList);
			}
		}
//		System.out.println("res"+set.size());
		return new ArrayList<TreeNode>(set);

	}

	public TreeNode buildTree(List<Integer> list) {
		TreeNode root = new TreeNode(list.get(0));

		TreeNode cur = root;
		for (int i = 1; i < list.size(); i++) {
			while (cur != null) {
				if (list.get(i) < cur.val) {
					if (cur.left == null) {
						TreeNode t = new TreeNode(list.get(i));
						cur.left = t;
						break;
					} else {
						cur = cur.left;
					}
				} else {
					if (cur.right == null) {
						TreeNode t = new TreeNode(list.get(i));
						cur.right = t;
						break;
					} else {
						cur = cur.right;
					}
				}
			}
			cur = root;

		}
		return root;
	}

	public void travel(TreeNode root, ArrayList<Integer> list) {
		if (root != null) {
			list.add(root.val);
			travel(root.left, list);
			travel(root.right, list);
		}
	}

	public List<List<Integer>> getList(int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> llist = new ArrayList<Integer>();
		res.add(llist);
		llist.add(1);
		for (int i = 2; i <= n; i++) {
			List<List<Integer>> tres = new ArrayList<List<Integer>>();
			for (List<Integer> tlist : res) {
				for (int j = 0; j <= tlist.size(); j++) {
					List<Integer> tmp = new ArrayList<Integer>(tlist);
					tmp.add(j, i);
					tres.add(tmp);
				}

			}
			res = tres;
		}
//		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		Q95 q = new Q95();
		q.generateTrees(3);

	}
}
