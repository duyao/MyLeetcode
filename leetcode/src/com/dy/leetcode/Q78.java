package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q78 {
	public List<List<Integer>> subsets(int[] S) {
	    Arrays.sort(S);
	    //���еĽ������2^n
	    //<<������
	    int totalNumber = 1 << S.length;
	    List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
	    //����������ֵĶ����Ʊ�ʾ
	    for (int i=0; i<totalNumber; i++) {
	        List<Integer> set = new LinkedList<Integer>();
	        for (int j=0; j<S.length; j++) {
//	        	System.out.println("i="+i+",j="+j+",i & 1<<j="+(i & (1<<j)));
	            //����ÿ��i������������е�1��ӽ���
	        	//��˰�1��ͣ�����ƣ�����ɸѡ�����е�
	        	if ((i & (1<<j)) != 0) {
	                set.add(S[j]);
	            }
	        }
	        collection.add(set);
	    }
	    return collection;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Q78 q = new Q78();
		q.subsets(nums);
	}
	

}
