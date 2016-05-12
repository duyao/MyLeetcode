package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q315_1 {
	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<Integer>();
		}
		int[] result = new int[nums.length];
		int[] sorted = new int[nums.length];
		// �Ը��������򣬴洢���Ǹ����ֵ���ţ�������ֵ
		for (int i = 0; i < nums.length; i++) {
			sorted[i] = i;
		}
		mergeSort(0, nums.length - 1, nums, sorted, result);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < result.length; i++) {
			list.add(result[i]);
		}

		return list;
	}

	public void mergeSort(int start, int end, int[] nums, int[] sorted,
			int[] result) {
		if (end <= start) {
			return;
		}
		int mid = (start + end) / 2;
		mergeSort(start, mid, nums, sorted, result);
		mergeSort(mid + 1, end, nums, sorted, result);

		merge(start, end, nums, sorted, result);

	}

	public void merge(int start, int end, int[] nums, int[] sorted, int[] result) {
		int mid = (start + end) / 2;
		int leftIndex = start;
		int rightIndex = mid + 1;
		
		// ��¼�ұߺϲ����ĸ���
		int rightCnt = 0;
		
		//��¼��������õ��±�
		int[] newIndex = new int[end - start + 1];
		int cnt = 0;
		
		while (leftIndex <= mid && rightIndex <= end) {
			//�Ƚϵ�ʱ��ʱ�����Ѿ��ź�������ֽ��бȽ�
			if (nums[sorted[leftIndex]] <= nums[sorted[rightIndex]]) {
				//��¼��Сֵ���±�
				newIndex[cnt] = sorted[leftIndex];
				//result����Ȼ�Ƕ�Ӧ�±��С��rightֵ
				//��Ϊ���飬�����ϲ�ʱ�������ұ��Ѿ��ϲ��ĸ���
				result[sorted[leftIndex]] += rightCnt;
				leftIndex++;
			} else {
				newIndex[cnt] = sorted[rightIndex];
				rightIndex++;
				rightCnt++;
			}
			cnt++;
		}
		//ʣ��ϲ�
		while(leftIndex <= mid){
			newIndex[cnt++] = sorted[leftIndex];
			result[sorted[leftIndex]] += rightCnt;
			leftIndex++;
		}
		while(rightIndex <= end){
			newIndex[cnt++] = sorted[rightIndex];
			rightIndex++;
		}
		//��������
		for(int i = start; i <= end; i++){
	        sorted[i] = newIndex[i - start];
	    }
		/*
		System.out.println("=====");
		System.out.println("start = "+start+", end = "+end);
		System.out.print("nums->");
		for (int j = 0; j < nums.length; j++) {
			System.out.print(nums[j]+",");
		}
		System.out.println();
		System.out.print("index->");
		for (int j = 0; j < sorted.length; j++) {
			System.out.print(sorted[j]+",");
		}
		System.out.println();
		System.out.print("result->");
		for (int j = 0; j < result.length; j++) {
			System.out.print(result[j]+",");
		}
		System.out.println();
		*/

	}
	
	public static void main(String[] args) {
		int[] nums = {12,34,4,3,7,5,2,6,1};
		Q315_1 q = new Q315_1();
		List<Integer> list = q.countSmaller(nums);
		System.out.println(list);
		System.out.println("====right===");
		Q315 qq = new Q315();
		List<Integer> listt = qq.countSmaller(nums);
		System.out.println(listt);
		
		
	}

}
