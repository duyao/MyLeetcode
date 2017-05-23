package com.dy.error.collection;

public class E13 {

	public static void main(String[] args) {
//		StringBuffer s1 = new StringBuffer(10);
		StringBuffer s1 = new StringBuffer(2);
    	s1.append("1234");
    	//Returns the current capacity. The capacity is the amount of storage available for newly inserted characters, 
    	//beyond which an allocation will occur.
    	//默认长度16，超过容量后，新的capacity=定义+new
    	System.out.println(s1.capacity());
    	System.out.println(s1.length());
	}
}
