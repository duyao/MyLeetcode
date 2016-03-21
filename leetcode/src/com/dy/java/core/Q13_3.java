package com.dy.java.core;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Q13_3 {

	public static void main(String[] args) {
		SortedSet<Item> mySet = new TreeSet();
		//Item中是按照partNum进行比较的
		mySet.add(new Item("To", 9234));
		mySet.add(new Item("Wi", 362));
		mySet.add(new Item("Mo", 1912));
		mySet.add(new Item("Mo", 12));
		mySet.add(new Item("Mo", 342));
		System.out.println(mySet);
		
		
		//使用comparator，类Item可以没有实现comparable
		//新建TreeSet通过传入比较器comparator来完成
		SortedSet<Item> setByDes = new TreeSet<Item>(new Comparator<Item>() {

			
			@Override
			public int compare(Item o1, Item o2) {
				//先按照des排序，对于相等的des则按照partNum排序
				String aDes = o1.getDescription();
				String bDes = o2.getDescription();
				if(aDes.compareTo(bDes) > 0){
					return 1;
				}else if(aDes.compareTo(bDes) < 0){
					return -1;
				}else{
					//注意前面有符号-，表示逆序，从大到小的顺序
					return -Integer.compare(o1.getPartNum(), o2.getPartNum());
				}
				//按照des排序，对于des相同，则只显示最小的partNum
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
