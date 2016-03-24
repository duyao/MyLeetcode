package com.dy.error.collection;

public class E14 {
	public static void main(String[] args) throws InterruptedException {
		final Object obj = new Object();
		Thread t1 = new Thread() {
			public void run() {
				synchronized (obj) {
					try {
						//休眠后释放锁
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
					//得到锁，通知其他进程进入就绪状态，但是不是得到锁
					//而是执行完该synchronized的代码块，才会将锁释放，其他进程才能进入运行状态
					obj.notifyAll();
					System.out.println("Thread 2 sent notify.");
				}
			}
		};
		t2.start();
	}
}
