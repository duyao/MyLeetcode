package com.dy.java.core;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Q13_6 {
	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map = new LinkedHashMap<String, String>(16, 0.75f,
				false);
		map.put("apple", "Æ»¹û");
		map.put("watermelon", "Î÷¹Ï");
		map.put("banana", "Ïã½¶");
		map.put("peach", "ÌÒ×Ó");
		System.out.println(map);
		map.get("banana");
		System.out.println(map);
		map.get("apple");
		System.out.println(map);

		
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}

}
