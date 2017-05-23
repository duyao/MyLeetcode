package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
//	//�ݹ�
//	public static List<List<Integer>> permute(int[] nums) {
//		List<List<Integer>> lists = new ArrayList<List<Integer>>();
//		backtrack(nums, 0, lists, new ArrayList<Integer>());
//		return lists;
//	}
//	
//	
//	public static void backtrack(int[] nums, int i,List<List<Integer>> lists,List<Integer> curList){
//		//�������㣬�Ϳ�����ӵ�����
//		if(curList.size() == nums.length){
//			lists.add(curList);
//			//���ص���һ��ݹ�
//			return ;
//		}
//
//		//ע��ѭ��������j <= curList.size()
//		//�������ܽ��µ�������ӵ�����λ��(�е��ں�)����һֱ�Ƕ�ͬһlist���޸�
//		for(int j = 0; j <= curList.size(); j++){
//			//��ȡ�������޸ĵ�list
//			List<Integer> newList = new ArrayList<Integer>(curList);
//			newList.add(j, nums[i]);
//			System.out.println("add "+"nums[i="+i+"]="+nums[i]+" at pos j="+j);
//			System.out.println("newList : ");
//			for (Integer integer : newList) {
//				System.out.print(integer + " ");
//			}
//			System.out.println();
//			backtrack(nums, i+1, lists, newList);
//		}
//		
//		
//	}
	
	
	//�ǵݹ�
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums == null  || nums.length == 0){
			return list;
		}
		//����ӵ�һ��Ԫ�أ�����list���뵽�������
		List<Integer> ll = new ArrayList<Integer>();
		ll.add(nums[0]);
		list.add(ll);
		//��������Ԫ�ؽ������
		//��һ��Ԫ���Ѿ���ӣ����Դ�1��ʼ
		for(int i = 1; i < nums.length; i++){
			
			List<List<Integer>> newList = new ArrayList<List<Integer>>();
			//ö�����е�λ��
			//j <= i��ʾλ��ʼ����Ԫ�ظ������
			for(int j = 0; j <= i; j++){
				//���������Ѿ����ڵ�list�������������λ��
				for (List<Integer>  tmp : list) {
					List<Integer> newLL = new ArrayList<Integer>(tmp);
					newLL.add(j,nums[i]);
					newList.add(newLL);
				}
			}
			//����list��ʹ�øո������޸���Ч
			list = newList;
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		List<List<Integer>> res = permute(nums);
		System.out.println(res.size());
		
	}
	

}
