package com.dy.error.collection;

public class E1 {

	
	public static void main(String[] args) {
		
		String s = "hello";
		String t = "hello";
		char[] c = {'h','e','l','l','o'};
		System.out.println(c.length);
		System.out.println(s.length());
		System.out.println("s"+s.hashCode());
		System.out.println("c"+c.hashCode());
		System.out.println("t"+t.hashCode());
		//equalԴ�����ж�s==t����Ϊ����ָ��ͬһ�ַ�������
		System.out.println(s.equals(t));
		//false����Ϊt��c���Ͳ�ͬ
		System.out.println(t.equals(c));
		System.out.println(s==t);
		System.out.println(t.equals(new String("hello")));
		
	}

}
