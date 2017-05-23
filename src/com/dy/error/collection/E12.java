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
	//���������ABCAABCABC
	//�п�����t1������ABC��t2��C��t1��ӡ��t2����bcȻ���ӡ
	//���һ���ǵ�һ�δ�ӡ���ǵڶ��δ�ӡ���Ӵ�
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
