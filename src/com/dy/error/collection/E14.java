package com.dy.error.collection;

public class E14 {
	public static void main(String[] args) throws InterruptedException {
		final Object obj = new Object();
		Thread t1 = new Thread() {
			public void run() {
				synchronized (obj) {
					try {
						//���ߺ��ͷ���
						obj.wait();
						System.out.println("Thread 1 wake up.");
					} catch (InterruptedException e) {
					}
				}
			}
		};
		t1.start();
		Thread.sleep(1000);// We assume thread 1 must start up within 1 sec.
		Thread t2 = new Thread() {
			public void run() {
				synchronized (obj) {
					//�õ�����֪ͨ�������̽������״̬�����ǲ��ǵõ���
					//����ִ�����synchronized�Ĵ���飬�ŻὫ���ͷţ��������̲��ܽ�������״̬
					obj.notifyAll();
					System.out.println("Thread 2 sent notify.");
				}
			}
		};
		t2.start();
	}
}
