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
		//listIterator��iterator��ָ������Ԫ��֮��ģ�������ĳһ��Ԫ��
		ListIterator<String> aIterator = a.listIterator();
		Iterator<String> bIterator = b.iterator();
		while(bIterator.hasNext()){
			if(aIterator.hasNext()){
				aIterator.next();
			}
			//���Ԫ������ָ����ָ���м����Ԫ��
			aIterator.add(bIterator.next());
		}
		System.out.println(a);
		bIterator = b.iterator();
		while(bIterator.hasNext()){
			bIterator.next();
			if(bIterator.hasNext()){
				bIterator.next();
				//ɾ��ָ����ߵ�Ԫ��
				bIterator.remove();
			}
			
		}
		System.out.println(b);
		//������List�ķ�����ɾ��a������b��Ԫ��
		a.removeAll(b);
		System.out.println(a);
		
		
	}

}
