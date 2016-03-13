package com.dy.java.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Q13_2 {
	public static void main(String[] args) {
		List<String> a = new LinkedList<>();
		a.add("Amy");
		a.add("Carl");
		a.add("Ercia");
		List<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloia");
		
		//Merge the word from b to a
		//listIterator和iterator是指向两个元素之间的，而不是某一个元素
		ListIterator<String> aIterator = a.listIterator();
		Iterator<String> bIterator = b.iterator();
		while(bIterator.hasNext()){
			if(aIterator.hasNext()){
				aIterator.next();
			}
			//添加元素是在指针所指的中间添加元素
			aIterator.add(bIterator.next());
		}
		System.out.println(a);
		bIterator = b.iterator();
		while(bIterator.hasNext()){
			bIterator.next();
			if(bIterator.hasNext()){
				bIterator.next();
				//删除指针左边的元素
				bIterator.remove();
			}
			
		}
		System.out.println(b);
		//这里是List的方法，删除a中所有b的元素
		a.removeAll(b);
		System.out.println(a);
		
		
	}

}
