package com.dy.error.collection;

public class E10 {
	public static void main(String[] args) {
		//replaceAll使用正则表达式
		//replace使用字符代替*至少0次，+至少1次，?0次或者1次
		String file = "com.jd".replaceAll("\\.", "/")+"MyMain";
//		String file = "com.jd".replaceAll(".", "/")+"MyMain";
		System.out.println(file);
	}

}
