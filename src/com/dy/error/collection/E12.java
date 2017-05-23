package com.dy.error.collection;

import java.util.ArrayList;
import java.util.List;

public class E12 {
	private List names = new ArrayList();
	public synchronized void add(String name){
		names.add(name);
	}
	public synchronized void printAll(){
		for(int i = 0; i < names.size(); i++){
			System.out.println(names.get(i)+" ");
		}
	}
	//结果可能是ABCAABCABC
	//有可能是t1加入了ABC，t2加C，t1打印，t2加入bc然后打印
	//结果一定是第一次打印的是第二次打印的子串
	public static void main(String[] args) {
		final E12 nl = new E12();
		for(int i = 0; i < 2; i++){
			new Thread(){
				public void run(){
					nl.add("A");
					nl.add("B");
					nl.add("C");
					nl.printAll();
					System.out.println("===============");
				}
			}.start();
			
		}
	}

}
