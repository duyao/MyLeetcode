package com.dy.java.core;

import java.util.BitSet;

public class PrimeNum {
	
	//bitset ����1˵��������
	public static void count(BitSet set){
		//length() -> Returns the "logical size" of this BitSet
		for(int i = 2; i < set.size(); i++){
			//��ʼ����ȫ����1
			set.set(i);
		}
		for(int i = 2; i < Math.sqrt(set.size()) + 1; i++){
			if(set.get(i)){
				for(int j = 2 * i; j < set.length(); j += i){
					//�����ı���ȫ�����Ϊ������
					set.clear(j);
					
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
					
					System.out.println(i);
				}
			}
		}
		System.out.println("count" + count);
		
	}

}
