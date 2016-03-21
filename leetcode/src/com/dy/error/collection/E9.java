package com.dy.error.collection;

public class E9 {
	
	public static void main(String[] args) {
//		Integer i1 = 59;
//		int i2 = 59;
//		Integer i3 = Integer.valueOf(59);
//		Integer i4 = new Integer(59);
		Integer i1 = 111111;
		int i2 = 111111;
		Integer i3 = Integer.valueOf(111111);
		Integer i4 = new Integer(111111);
		//当为59时，1-3都是true
		//因为jvm对于小于1字节的以下的整数都会加载进内存，除非用new Integer()显示声明新建对象
		//因此1-3都是指向同一个对象,因此12真，4假
		//而3是对于int进行比较值的大小
		//当为111111时，13true，24false
		//i3的valueof会先判断数字是都小于1字节(127)，若小于不产生新对象，大于127则产生新对象
		System.out.println(i1 == i2);
		System.out.println(i1 == i3);
		//24和23何时都相等，因为2是int3是Integer，因为一个是基本类型，一个是封装类
		System.out.println(i2 == i4);
		System.out.println(i3 == i4);
		
		System.out.println(i2 == i3);
		//无论何时14不等1与4是不同的对象，因为4被new，虽然他们都是integer
		System.out.println(i1 == i4);

	}

}
