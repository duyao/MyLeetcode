package com.dy.error.collection;

public class E3 {
	public static void main(String[] args) {
		byte a1 = 2, a2 = 4, a3;
		short s =16;
		//高级向低级必须进行强制类型转换
		//byte8 < char16unicode < short16 < int32 < long64 < float32单精度 < double64双精度
//		a2 = s;
		a2 = (byte) s;

		//byte, short, char 三种类型间不会相互转换，他们三者在计算时，首先会转换为int类型
//		a3 = a1 * a2;
		a3 = (byte) (a1 * a2);
//		a3 = a1 * a2;a3改为int

	}

}
