package com.dy.error.collection;

public class E6 {
	public static void main(String[] args) {
		float f = 42.0f;
		float f1[] = new float[2];
		float f2[] = new float[2];
		float[] f3 = f1;
		long x = 42;
		f1[0] = 42.0f;
		boolean b = (f1==f2);
		System.out.println(b);
		//自动转化，低转高，因此long转为float
		b = (x==f1[0]);
		System.out.println(b);
		b = (f1==f3);
		System.out.println(b);
	}
}
