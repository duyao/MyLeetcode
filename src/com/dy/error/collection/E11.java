package com.dy.error.collection;

class C {
	C() {
		System.out.println("C");
	}
}

class A {
	C c = new C();

	A() {
		this("该方法调用A(String s)的方法A");
		System.out.println("A");
	}

	A(String s) {
		System.out.println(s);
	}
}

public class E11 extends A {

	E11() {
//		super("B");
		System.out.println("B");
	}

	public static void main(String[] args) {
		//初始化过程
		//1父静态成员和静态代码块
		//2子静态成员和静态代码块
		//3父普通成员和代码块及构造方法
		//4子普通成员和代码块及构造方法
		new E11();
		//因此父即A的构造方法new c，父的构造方法已经显示调用，即下一句super
		//再执行super这是父的构造方法A(String s)
		//然后输出B
		//如果没有super这句就执行默认的构造方法即无参数的
	}

}
