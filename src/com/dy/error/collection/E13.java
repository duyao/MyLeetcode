package com.dy.error.collection;

public class E13 {

	public static void main(String[] args) {
//		StringBuffer s1 = new StringBuffer(10);
		StringBuffer s1 = new StringBuffer(2);
    	s1.append("1234");
    	//Returns the current capacity. The capacity is the amount of storage available for newly inserted characters, 
    	//beyond which an allocation will occur.
    	//Ĭ�ϳ���16�������������µ�capacity=����+new
    	System.out.println(s1.capacity());
    	System.out.println(s1.length());
	}
}
