package com.dy.error.collection;

public class E7 {
	private static void testMethod(){
		System.out.println("testMethod");
	}

	public static void main(String[] args) {
		//1.null可以被转换成任意类型
		//2.静态方法可以由该类直接调用
		E7.testMethod();
		//若无static，则会报空指针
		((E7)null).testMethod();
		
	}
	

}
