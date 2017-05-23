package com.dy.error.collection;

public class E15 {
	//加数是常量，先运算后赋值
	//加数是变量，先转类型，再运算
	public static void main(String[] args) {
		byte b1=1,b2=2,b3,b6; 
		final byte b4=4,b5=6; 
		//b4b5是byte相加计算后升为int，而其实final，因此编译时就已经是10了
		b6=b4+b5; 
		//b1+b2计算时候提升为int，而b3是byte不是同一类型，会报错，需要强制转换
//		b3=(b1+b2);
//		System.out.println(b3+b6);
		System.out.println(b6);

		Byte b7  = 8+2;
		System.out.println(b7);

	}

}
