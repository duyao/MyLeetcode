package com.dy.error.collection;

public class E5 {
	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				pong();
			}};
			//runδ�������̣߳��൱�ں�������
			//pongping
//			t.run();
			//start�ǿ������̣߳��õ�ʱ��Ƭ�����У������run��������������Ĵ���
			//pingpong
			t.start();
			System.out.println("ping");
		
	}
	static void pong(){
		System.out.println("pong");
	}
}
