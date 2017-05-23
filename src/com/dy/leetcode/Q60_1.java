package com.dy.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q60_1 {
	public String getPermutation(int n, int k) {
		List<String> myList = new ArrayList<String>();
		myList.add("");
		backtrack(n, 1, myList);
		Collections.sort(myList);
//		System.out.println("in main");
//		System.out.println(myList);
		return myList.get(k - 1);

	}

	public void backtrack(int x, int cur, List<String> list) {
		if (x < cur) {
//			System.out.println("in backtrack");
//			System.out.println(list);
			return;
		} else {
			ArrayList<String> tmpList = new ArrayList<String>();
			for (String string : list) {
				for (int i = 0; i <= string.length(); i++) {
					StringBuffer tmp = new StringBuffer(string);
					tmp.insert(i, cur);
					tmpList.add(tmp.toString());
				}
			}
			//���ﲻ����ôд����Ϊ�����Ļ�list��ָ��tmpList�ĵ�ַ���ڷ���ʱ���޷��õ�������ֵ
			//list = tmpList;
			//ʹ��list��������������գ������
			list.clear();
			list.addAll(tmpList);
			backtrack(x, cur + 1, list);

		}

	}

	public static void main(String[] args) {
		Q60_1 q = new Q60_1();
		System.out.println(q.getPermutation(4, 24));
	}

}
