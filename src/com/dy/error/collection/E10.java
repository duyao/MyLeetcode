package com.dy.error.collection;

public class E10 {
	public static void main(String[] args) {
		//replaceAllʹ��������ʽ
		//replaceʹ���ַ�����*����0�Σ�+����1�Σ�?0�λ���1��
		String file = "com.jd".replaceAll("\\.", "/")+"MyMain";
//		String file = "com.jd".replaceAll(".", "/")+"MyMain";
		System.out.println(file);
	}

}
