package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q78_1 {
	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		//���ʱ��֤����
		Arrays.sort(nums);
		f(nums, 0, new ArrayList<Integer>(), res);
		return res;
	}

	public void f(int[] nums, int index, List<Integer> path,
			List<List<Integer>> res) {
		
		for (int i = index; i < nums.length; i++) {
			path.add(nums[i]);
			//�������һ��Ҫnewһ������Ȼ����pathɾ��Ԫ�ػ�Ӱ������
//			res.add(path);
			res.add(new ArrayList<Integer>(path));
			f(nums, i + 1, path, res);
			path.remove(path.size() - 1);
		}

	}
	
	public List<List<Integer>> subsets1(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		Arrays.sort(nums);
		for (Integer i : nums) {
//			
			
			
//			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
//			for (List<Integer> sub : res) {
//				//����sub��Ӻ�res�����ϸı�
//				sub.add(i);
//				tmp.add(sub);
//			}
//			res.addAll(tmp);
			
//			// java.util.ConcurrentModificationException
//			List<List<Integer>> tmp = new ArrayList<List<Integer>>(res);
//			for (List<Integer> sub : tmp) {
//				List<Integer> tt = new ArrayList<Integer>(sub);
//				tt.add(i);
//				tmp.add(tt);
//			}
//			res = tmp;
			
			
			
			//��¼����ѭ����ӵ�list,һ����res�޹أ���ȻConcurrentModificationException
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for (List<Integer> sub : res) {
				//����sub������������Ȼ�޸�sub��res��ı�
				List<Integer> list = new ArrayList<Integer>(sub);
				list.add(i);
				tmp.add(list);
			}
			//ͬ����res
			res.addAll(tmp);
			
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		Q78_1 q = new Q78_1();
		int[] nums = {3,1,2};
		List<List<Integer>> list = q.subsets1(nums);
		System.out.println(list);
	}

}
