package com.dy.error.collection;

public class E15 {
	public static void main(String[] args) {
		byte b1=1,b2=2,b3,b6; 
		final byte b4=4,b5=6; 
		//b4b5��byte��Ӽ������Ϊint������ʵfinal����˱���ʱ���Ѿ���10��
		b6=b4+b5; 
		//b1+b2����ʱ������Ϊint����b3��byte����ͬһ���ͣ��ᱨ����Ҫǿ��ת��
		//b3=(b1+b2); 
//		System.out.println(b3+b6);
		System.out.println(b6);
	}

}
