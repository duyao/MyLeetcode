package com.dy.java.core;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Q13_4 {
	public static void main(String[] args) {
		Queue<Integer>  prq = new PriorityQueue();
		Random r = new Random();
		System.out.println("--------------add----------------");
		for(int i = 0; i < 5; i++){
			int addNum = r.nextInt(100);
			prq.add(addNum);
			System.out.println("add num" + addNum);
			//ͨ����ӡ�Ķ��п��Կ������������ڲ���һ�����򣬵�����СԪ��һ���ڶ�ͷ
			//��ӵı仯���̾��ǽ���Ԫ�ط������Ȼ�������
			System.out.println("prq" + prq);
		}
		System.out.println("----------------remove-----------------------");
		for(int i = 0; i < 5; i++){
			int x = prq.peek();
			System.out.println("remove num" + x);
			prq.remove();
			//ͨ����ӡ�Ķ��п��Կ������������ڲ���һ�����򣬵�����СԪ��һ���ڶ�ͷ
			//ɾ���ı仯���̾��ǽ����һ��Ԫ�أ����ڶѶ���Ȼ���ڽ��е���
			System.out.println("prq" + prq);
		}
		
		
		
	}

}
