package com.dy.java.core;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class Q13_5 {
	public static void main(String[] args) throws Exception {
		// String a = new String("a");
		// String b = new String("b");
		// Map weakmap = new WeakHashMap();
		// Map map = new HashMap();
		// map.put(a, "aaa");
		// map.put(b, "bbb");
		// weakmap.put(a, "aaa");
		// weakmap.put(b, "bbb");
		// map.remove(a);
		// a = null;
		// b = null;
		// System.gc();
		// Iterator i = map.entrySet().iterator();
		// while (i.hasNext()) {
		// Map.Entry en = (Map.Entry) i.next();
		// System.out.println("map:" + en.getKey() + ":" + en.getValue());
		// }
		// Iterator j = weakmap.entrySet().iterator();
		// while (j.hasNext()) {
		// Map.Entry en = (Map.Entry) j.next();
		// System.out.println("weakmap:" + en.getKey() + ":" + en.getValue());
		// }

		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();
		for (int i = 0; i < 1000; i++) {
			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
			d.put(new byte[1000][1000], new byte[1000][1000]);
			maps.add(d);
			System.gc();
			System.err.println(i);
//			for (int j = 0; j < i; j++) {
//				System.err.println(j + " size" + maps.get(j).size());
//			}
		}
	}

}
