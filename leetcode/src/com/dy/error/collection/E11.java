package com.dy.error.collection;

class C {
	C() {
		System.out.println("C");
	}
}

class A {
	C c = new C();

	A() {
		this("�÷�������A(String s)�ķ���A");
		System.out.println("A");
	}

	A(String s) {
		System.out.println(s);
	}
}

public class E11 extends A {

	E11() {
//		super("B");
		System.out.println("B");
	}

	public static void main(String[] args) {
		//��ʼ������
		//1����̬��Ա�;�̬�����
		//2�Ӿ�̬��Ա�;�̬�����
		//3����ͨ��Ա�ʹ���鼰���췽��
		//4����ͨ��Ա�ʹ���鼰���췽��
		new E11();
		//��˸���A�Ĺ��췽��new c�����Ĺ��췽���Ѿ���ʾ���ã�����һ��super
		//��ִ��super���Ǹ��Ĺ��췽��A(String s)
		//Ȼ�����B
		//���û��super����ִ��Ĭ�ϵĹ��췽�����޲�����
	}

}
