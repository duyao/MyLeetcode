package com.dy.error.collection;

public class E3 {
	public static void main(String[] args) {
		byte a1 = 2, a2 = 4, a3;
		short s =16;
		//�߼���ͼ��������ǿ������ת��
		//byte8 < char16unicode < short16 < int32 < long64 < float32������ < double64˫����
//		a2 = s;
		a2 = (byte) s;

		//byte, short, char �������ͼ䲻���໥ת�������������ڼ���ʱ�����Ȼ�ת��Ϊint����
//		a3 = a1 * a2;
		a3 = (byte) (a1 * a2);
//		a3 = a1 * a2;a3��Ϊint

	}

}
