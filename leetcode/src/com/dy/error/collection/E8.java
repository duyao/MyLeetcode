package com.dy.error.collection;

public class E8 {
	public void add(Byte b){
		b = b++;
	}
	public void test(){
		Byte a = 127;
		Byte b = 127;
		add(++a);
		//a = -128,++a�ȼӣ�����add�ޱ仯����Ϊ��a++
		System.out.println(a + " ");
		add(b);
		System.out.println(b + " ");
	}
	public static void main(String[] args) {
		E8 e = new E8();
		e.test();
	}

}
