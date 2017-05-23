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
			//通过打印的队列可以看出来，队列内部不一定有序，但是最小元素一定在队头
			//添加的变化过程就是将新元素放在最后，然后调整堆
			System.out.println("prq" + prq);
		}
		System.out.println("----------------remove-----------------------");
		for(int i = 0; i < 5; i++){
			int x = prq.peek();
			System.out.println("remove num" + x);
			prq.remove();
			//通过打印的队列可以看出来，队列内部不一定有序，但是最小元素一定在队头
			//删除的变化过程就是将最后一个元素，放在堆顶，然后在进行调整
			System.out.println("prq" + prq);
		}
		
		
		
	}

}
