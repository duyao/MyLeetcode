package com.dy.error.collection;

public class E5 {
	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				pong();
			}};
			//run未开启新线程，相当于函数调用
			//pongping
//			t.run();
			//start是开启新线程，得到时间片就运行，无需等run结束才运行下面的代码
			//pingpong
			t.start();
			System.out.println("ping");
		
	}
	static void pong(){
		System.out.println("pong");
	}
}
