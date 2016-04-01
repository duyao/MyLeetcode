package com.dy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<String>();
		if(s == null || s.length() < 4){
			return list;
		}
		for(int i = 1; i < 4;i++){
			String s1 = s.substring(0, i);
			//ע���ж��Ƿ񳬳����鳤�ȣ���ÿ��ѭ��ǰ�ж��Ƿ�Ϸ��������ܼ��ٺ������õ��ж�
			for(int j = 1; isVaild(s1) && j < 4 && i+j < s.length();j++){
				String s2 = s.substring(i, i+j);
				for(int k = 1; isVaild(s2) && k < 4 && i+j+k < s.length(); k++){
					String s3 = s.substring(i+j, i+j+k);
					String s4 = s.substring(i+j+k, s.length());
					if(isVaild(s3) && isVaild(s4)){
						list.add(s1+"."+s2+"."+s3+"."+s4);
					}
				}
			}
		}
		return list;
	}
	public boolean isVaild(String s){
		if(s.length() == 1){
			return true;
		}else if(s.length() == 2 && s.charAt(0) != '0'){
			return true;
		}else if(s.length() == 3 && s.charAt(0) != '0' && Integer.valueOf(s) < 256){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		String s = "01111";
		String ss = s.substring(4,4);
		
		Q93 q = new Q93();
		List<String> list = q.restoreIpAddresses(s);
		System.out.println(list);
	}

}
