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
		//equal源码先判断s==t，因为两者指向同一字符串常量
		System.out.println(s.equals(t));
		//false，因为t和c类型不同
		System.out.println(t.equals(c));
		System.out.println(s==t);
		System.out.println(t.equals(new String("hello")));
		
	}

}
