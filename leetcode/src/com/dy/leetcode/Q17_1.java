package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q17_1 {

	public List<String> letterCombinations(String digits) {

		if (digits == null || digits.length() == 0) {
			return new ArrayList<>();
		}
		List<String> info = new ArrayList<>();
		info.add("abc");
		info.add("def");
		info.add("ghi");
		info.add("jkl");
		info.add("mno");
		info.add("pqrs");
		info.add("tuv");
		info.add("wxyz");
		List<String> list = new ArrayList<>();
		list.add("");
		//����������Ԫ�صı���
		for (int i = 0; i < digits.length(); i++) {
			//tlist��ű�������ӵ�Ԫ��
			List<String> tlist = new ArrayList<>();
			for (int k = 0; k < list.size(); k++) {
				
				int index = digits.charAt(i) - 48 - 2;
				String cur = info.get(index);
				
				for (int j = 0; j < cur.length(); j++) {
					//����һ�εĻ����ϼ������
					StringBuffer sb = new StringBuffer(list.get(k));
					//��ÿ��Ԫ�ص�λ�����滻
					sb.insert(i, cur.charAt(j));
					tlist.add(sb.toString());
				}

			}
			list = tlist;

		}

		return list;
	}

	public static void main(String[] args) {
		Q17_1 q = new Q17_1();
		String digits = "234";
		List<String> list = q.letterCombinations(digits);
		System.out.println(list);

	}

}
