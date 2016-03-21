package com.dy.java.core;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Q13_3 {

	public static void main(String[] args) {
		SortedSet<Item> mySet = new TreeSet();
		//Item���ǰ���partNum���бȽϵ�
		mySet.add(new Item("To", 9234));
		mySet.add(new Item("Wi", 362));
		mySet.add(new Item("Mo", 1912));
		mySet.add(new Item("Mo", 12));
		mySet.add(new Item("Mo", 342));
		System.out.println(mySet);
		
		
		//ʹ��comparator����Item����û��ʵ��comparable
		//�½�TreeSetͨ������Ƚ���comparator�����
		SortedSet<Item> setByDes = new TreeSet<Item>(new Comparator<Item>() {

			
			@Override
			public int compare(Item o1, Item o2) {
				//�Ȱ���des���򣬶�����ȵ�des����partNum����
				String aDes = o1.getDescription();
				String bDes = o2.getDescription();
				if(aDes.compareTo(bDes) > 0){
					return 1;
				}else if(aDes.compareTo(bDes) < 0){
					return -1;
				}else{
					//ע��ǰ���з���-����ʾ���򣬴Ӵ�С��˳��
					return -Integer.compare(o1.getPartNum(), o2.getPartNum());
				}
				//����des���򣬶���des��ͬ����ֻ��ʾ��С��partNum
//				return aDes.compareTo(bDes);
			}
			
		});
//		setByDes.addAll(mySet);
		setByDes.add(new Item("To", 9234));
		setByDes.add(new Item("Wi", 362));
		setByDes.add(new Item("Mo", 1912));
		setByDes.add(new Item("Mo", 12));
		setByDes.add(new Item("Mo", 342));
		System.out.println(setByDes);
		
		
		
		
		
		
		
		
	}
}
