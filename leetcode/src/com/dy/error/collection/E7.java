package com.dy.error.collection;

public class E7 {
	private static void testMethod(){
		System.out.println("testMethod");
	}

	public static void main(String[] args) {
		//1.null���Ա�ת������������
		//2.��̬���������ɸ���ֱ�ӵ���
		E7.testMethod();
		//����static����ᱨ��ָ��
		((E7)null).testMethod();
		
	}
	

}
