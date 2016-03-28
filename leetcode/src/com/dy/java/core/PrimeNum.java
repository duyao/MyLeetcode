package com.dy.java.core;

import java.util.BitSet;

public class PrimeNum {
	
	//bitset 被置1说明是素数
	public static void count(BitSet set){
		//length() -> Returns the "logical size" of this BitSet
		for(int i = 2; i < set.size(); i++){
			//初始化，全部置1
			set.set(i);
		}
		for(int i = 2; i * i < set.size(); i++){
			if(set.get(i)){
				for(int j = i + i; j < set.length(); j += i){
					//素数的倍数全部标记为非素数
					set.clear(j);
					if(j == 30){
						System.out.println(i);
					}
					
				}
			}
		}
	}
	public static void main(String[] args) {
		BitSet b = new BitSet(2000000);
		count(b);
		int count = 0;
		for(int i = 2; i < b.length(); i++){
			if(b.get(i)){
				count ++;
				if(i < 100){
					
//					System.out.println(i);
				}
			}
		}
		System.out.println("count" + count);
		
	}

}
