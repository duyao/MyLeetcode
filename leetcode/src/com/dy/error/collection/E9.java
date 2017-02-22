package com.dy.error.collection;

public class E9 {
	
	
	//装箱就是  自动将基本数据类型转换为包装器类型；拆箱就是  自动将包装器类型转换为基本数据类型。
	//主要是看等号左边的定义的类型
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
		
		
		//Integer、Short、Byte、Character、Long这几个类的valueOf方法的实现是类似的。
		//Double、Float的valueOf方法的实现是类似的。
		Double d1 = 34.0;
		Double d2 = 34.0;
		System.out.println("d1 == d2  ->  " + (d1 == d2));
		
		
		//当 "=="运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象，
		//而如果其中有一个操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）
		Long ll = 3l;
		int a = 1;
		int b = 2;
//		long b = 2;
		System.out.println(ll == (a + b));
		//对于包装器类型，equals方法并不会进行类型转换,比较是否类型相同
		System.out.println(ll.equals(a + b));
		

	}

}
